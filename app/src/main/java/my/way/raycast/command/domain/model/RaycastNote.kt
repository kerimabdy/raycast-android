package my.way.raycast.command.domain.model

import androidx.compose.runtime.Immutable
import java.time.Instant

@Immutable
data class RaycastNote(
    val createdAt: Instant,
    val deletedAt: Instant?,
    val document: String,    // Base64-encoded JSON string
    val documentSchemaVersion: Int,
    val id: String,
    val modifiedAt: Instant,
    val openedAt: Instant,
    val text: String,
    val title: String
)
