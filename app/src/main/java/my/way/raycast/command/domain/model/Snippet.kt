package my.way.raycast.command.domain.model

import androidx.compose.runtime.Immutable
import java.time.Instant

@Immutable
data class Snippet(
    val accessedAt: Instant,
    val alias: String,
    val category: String,
    val copyCount: Int,
    val createdAt: Instant,
    val modifiedAt: Instant,
    val name: String,
    val text: String
)
