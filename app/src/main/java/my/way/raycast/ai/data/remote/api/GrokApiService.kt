package my.way.raycast.ai.data.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import my.way.raycast.BuildConfig
import my.way.raycast.ai.data.remote.dto.GrokMessageDto
import my.way.raycast.ai.data.remote.dto.GrokRequestDto
import my.way.raycast.ai.data.remote.dto.GrokStreamResponseDto
import my.way.raycast.ai.domain.model.AiRequest
import my.way.raycast.core.domain.util.NetworkError
import my.way.raycast.core.domain.util.Result

class GrokApiService(
    private val client: HttpClient,
    private val apiKey: String,
) {
    fun streamAiResponse(aiRequest: AiRequest): Flow<Result<GrokStreamResponseDto, NetworkError>> {
        return safeStreamCall<GrokStreamResponseDto>(
            execute = {
                client.post("https://api.x.ai/v1/chat/completions") {
                    header("Authorization", "Bearer ${BuildConfig.XAI_API_KEY}")
                    contentType(ContentType.Application.Json)
                    setBody(
                        GrokRequestDto(
                            model = "grok-4-fast-non-reasoning",
                            messages = listOf(
                                GrokMessageDto(
                                    role = "user",
                                    content = aiRequest.prompt
                                )
                            ),
                            temperature = aiRequest.temperature,
                            maxTokens = aiRequest.maxToken,
                            stream = true
                        )
                    )
                }
            }
        )
    }

}