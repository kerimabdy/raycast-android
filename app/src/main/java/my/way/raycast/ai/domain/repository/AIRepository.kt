package my.way.raycast.ai.domain.repository

import kotlinx.coroutines.flow.Flow
import my.way.raycast.ai.domain.model.AiRequest
import my.way.raycast.ai.domain.model.Message
import my.way.raycast.ai.domain.model.StreamEvent
import my.way.raycast.core.domain.util.Error
import my.way.raycast.core.domain.util.Result

interface AIRepository {
    fun getMessage(): Flow<List<Message>>
    suspend fun sendMessage(content: String): Result<Message, Error>
    suspend fun saveMessage(message: Message)

    fun streamResponse(aiRequestContent: AiRequest): Flow<Result<StreamEvent, Error>>
}
