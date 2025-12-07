package my.way.raycast.command.domain.model

import androidx.compose.runtime.Immutable
import java.time.Instant

@Immutable
data class AiChat(
    val accessedAt: Instant,
    val additionalTools: List<Tool>,
    val createdAt: Instant,
    val id: String,
    val messages: List<Message>,
    val model: String,
    val modifiedAt: Instant,
    val platform: String,
    val temperature: Double,
    val title: String
) {
}

@Immutable
data class Tool(
    val id: String,
    val name: String
)

@Immutable
data class Message(
    val attachments: List<String>, // Assuming attachments are strings; adjust if needed
    val id: String,
    val modelUsed: String,
    val platform: String,
    val source: String,
    val text: String,
    val timestamp: Instant
)