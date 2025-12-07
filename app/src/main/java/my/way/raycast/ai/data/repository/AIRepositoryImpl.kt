package my.way.raycast.ai.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import my.way.raycast.BuildConfig
import my.way.raycast.ai.data.local.dao.MessageDao
import my.way.raycast.ai.data.mapper.toChunkStringOrNull
import my.way.raycast.ai.data.mapper.toDomain
import my.way.raycast.ai.data.mapper.toEntity
import my.way.raycast.ai.data.mapper.toMessage
import my.way.raycast.ai.data.remote.api.GrokApiService
import my.way.raycast.ai.data.remote.dto.GrokMessageDto
import my.way.raycast.ai.data.remote.dto.GrokRequestDto
import my.way.raycast.ai.data.remote.dto.GrokResponseDto
import my.way.raycast.ai.domain.model.AiRequest
import my.way.raycast.ai.domain.model.Message
import my.way.raycast.ai.domain.model.StreamEvent
import my.way.raycast.ai.domain.repository.AIRepository
import my.way.raycast.core.data.networking.safeCall
import my.way.raycast.core.domain.util.Error
import my.way.raycast.core.domain.util.Result
import my.way.raycast.core.domain.util.map


class AIRepositoryImpl(
    private val dao: MessageDao,
    private val httpClient: HttpClient,
    private val grokApiService: GrokApiService,
) : AIRepository {
    override fun getMessage(): Flow<List<Message>> =
        dao.getAllMessage().map { entities ->
            entities.map { entity -> entity.toDomain() }
        }

    override suspend fun sendMessage(content: String): Result<Message, Error> {
        return safeCall<GrokResponseDto> {
            httpClient.post("https://api.x.ai/v1/chat/completions") {
                header("Authorization", "Bearer ${BuildConfig.XAI_API_KEY}")
                contentType(ContentType.Application.Json)
                setBody(
                    GrokRequestDto(
                        model = "grok-4-fast-non-reasoning",
                        messages = listOf(GrokMessageDto(role = "user", content = content)),
                        temperature = 0.7,
                        maxTokens = 512,
                        stream = false
                    )
                )
            }
        }.map { response ->
            response.toMessage()
        }
    }

    override suspend fun saveMessage(message: Message) {
        dao.insertMessage(message.toEntity())
    }

    override fun streamResponse(aiRequestContent: AiRequest): Flow<Result<StreamEvent, Error>> =
        grokApiService.streamAiResponse(aiRequest = aiRequestContent).map {
            it.map { response ->
                StreamEvent.Chunk(response.toChunkStringOrNull() ?: "") as StreamEvent
            }
        }.onCompletion { error ->
            if (error == null) {
                emit(Result.Success(StreamEvent.Finished))
            }
        }
}