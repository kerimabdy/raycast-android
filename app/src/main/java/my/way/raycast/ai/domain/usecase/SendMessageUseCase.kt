package my.way.raycast.ai.domain.usecase

import my.way.raycast.ai.domain.model.Message
import my.way.raycast.ai.domain.repository.AIRepository
import my.way.raycast.core.domain.util.Error
import my.way.raycast.core.domain.util.Result
import my.way.raycast.core.domain.util.onSuccess

class SendMessageUseCase(
    private val AIRepository: AIRepository,
) {
    suspend operator fun invoke(content: String): Result<Message, Error> {
        val userMsg = Message(content = content, isUser = true)
        AIRepository.saveMessage(userMsg)
        val response = AIRepository.sendMessage(content)
        response.onSuccess {
            AIRepository.saveMessage(it)
        }
        return response
    }
}


