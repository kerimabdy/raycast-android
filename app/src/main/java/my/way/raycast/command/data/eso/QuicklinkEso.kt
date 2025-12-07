package my.way.raycast.command.data.eso

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class QuicklinkEso(
    val iconName: String? = null,
    val isEnabled: Boolean,
    val name: String,
    val openCount: Int,
    val updatedAt: String, // Or a proper Date/Time type like Instant or LocalDateTime
    val urlString: String,
    val uuid: String
)
