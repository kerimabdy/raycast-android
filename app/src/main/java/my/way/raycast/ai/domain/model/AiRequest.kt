package my.way.raycast.ai.domain.model


data class AiRequest(
    val prompt: String,
    val temperature: Double,
    val maxToken: Int
)
