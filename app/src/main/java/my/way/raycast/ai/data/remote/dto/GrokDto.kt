package my.way.raycast.ai.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GrokMessageDto(
    val role: String,
    val content: String
)

@Serializable
data class GrokRequestDto(
    val model: String,
    val messages: List<GrokMessageDto>,
    val temperature: Double,
    val maxTokens: Int,
    val stream: Boolean
)

@Serializable
data class GrokResponseDto(
    val choices: List<GrokChoiceDto>
)

@Serializable
data class GrokChoiceDto(
    val message: GrokMessageDto
)

@Serializable
data class GrokStreamResponseDto(
    val choices: List<Choice>
)

@Serializable
data class Choice(
    val delta: Delta
)

@Serializable
data class Delta(
    val content: String? = null
)
