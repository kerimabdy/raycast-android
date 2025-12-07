package my.way.raycast.ai.domain.model

data class Message(
    val id: Long = 0,
    val content: String,
    val isUser: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)
