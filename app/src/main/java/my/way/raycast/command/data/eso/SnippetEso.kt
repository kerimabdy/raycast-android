package my.way.raycast.command.data.eso

import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class SnippetEso(
    val accessedAt: String,
    val alias: String? = null,
    val category: String,
    val copyCount: Int,
    val createdAt: String,
    val modifiedAt: String,
    val name: String,
    val text: String
)
