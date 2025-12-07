package my.way.raycast.command.domain.model

import androidx.compose.runtime.Immutable
import java.time.LocalDateTime

@Immutable
data class AICommand(
    val accessedAt: String,
    val count: Int,
    val createdAt: LocalDateTime,
    val highlightEdits: Boolean,
    val iconName: String,
    val model: String,
    val modifiedAt: LocalDateTime,
    val promptTemplate: String,
    val temperature: Double,
    val title: String,
    val uuid: String
)
