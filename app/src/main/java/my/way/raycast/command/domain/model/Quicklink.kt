package my.way.raycast.command.domain.model

import androidx.compose.runtime.Immutable
import java.time.Instant

@Immutable
data class Quicklink(
    val iconName: String,
    val isEnabled: Boolean,
    val name: String,
    val openCount: Int,
    val updatedAt: Instant, // Or a proper Date/Time type like Instant or LocalDateTime
    val urlString: String,
    val uuid: String
)
