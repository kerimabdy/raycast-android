package my.way.raycast.command.data.eso

import kotlinx.serialization.Serializable

@Serializable
data class AICommandEso(
    val accessedAt: String,
    val count: Int,
    val createdAt: String,
    val highlightEdits: Boolean,
    val iconName: String,
    val model: String,
    val modifiedAt: String,
    val promptTemplate: String,
    val temperature: Double,
    val title: String,
    val uuid: String
)
