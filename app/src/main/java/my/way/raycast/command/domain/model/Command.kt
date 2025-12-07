
package my.way.raycast.command.domain.model

import androidx.compose.runtime.Immutable
import java.time.Instant
import java.time.LocalDateTime

//@Immutable
//data class Command(
//    val clientUpdatedAt: Instant,
//    val createdAt: Instant,
//    val id: String,
//    val kind: CommandType,
//    val updatedAt: Instant,
//    val value: String,
//    val version: Int,
//)


@Immutable
sealed class Command {
    abstract val id: String
    abstract val clientUpdatedAt: Instant
    abstract val createdAt: Instant
    abstract val kind: CommandType
    abstract val updatedAt: Instant
    abstract val version: Int

    @Immutable
    data class Quicklink(
        override val id: String,
        override val clientUpdatedAt: Instant,
        override val createdAt: Instant,
        override val updatedAt: Instant,
        override val kind: CommandType,
        override val version: Int,
        val iconName: String?,
        val isEnabled: Boolean,
        val name: String,
        val openCount: Int,
        val updatedAtLocal: LocalDateTime,
        val urlString: String,
        val uuid: String,
    ): Command()

    @Immutable
    data class AICommand(
        override val id: String,
        override val clientUpdatedAt: Instant,
        override val createdAt: Instant,
        override val updatedAt: Instant,
        override val kind: CommandType,
        override val version: Int,
        val accessedAt: LocalDateTime,
        val count: Int,
        val createdAtLocal: LocalDateTime,
        val highlightEdits: Boolean,
        val iconName: String,
        val model: String,
        val modifiedAt: LocalDateTime,
        val promptTemplate: String,
        val temperature: Double,
        val title: String,
        val uuid: String
    ): Command()

    @Immutable
    data class Snippet(
        override val id: String,
        override val clientUpdatedAt: Instant,
        override val createdAt: Instant,
        override val updatedAt: Instant,
        override val kind: CommandType,
        override val version: Int,
        val accessedAt: LocalDateTime,
        val alias: String?,
        val category: String,
        val copyCount: Int,
        val createdAtLocal: LocalDateTime,
        val modifiedAt: LocalDateTime,
        val name: String,
        val text: String
    ): Command()



    data class Unknown(
        override val id: String,
        override val clientUpdatedAt: Instant,
        override val updatedAt: Instant,
        override val version: Int,
        override val createdAt: Instant,
        override val kind: CommandType
    ) : Command()
}