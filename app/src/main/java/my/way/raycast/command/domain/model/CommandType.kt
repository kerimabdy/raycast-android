package my.way.raycast.command.domain.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Immutable
data class CommandType(val name: String) {
    companion object Companion {
        @Stable val AiChat = CommandType("aiChat")
        @Stable val Snippet = CommandType("snippet")
        @Stable val Quicklink = CommandType("quicklink")
        @Stable val RaycastNote = CommandType("raycastNote")
        @Stable val RaycastConfiguration = CommandType("raycastConfiguration")
        @Stable val Search = CommandType("search")
        @Stable val AICommand = CommandType("aiCommand")

        fun fromString(name: String): CommandType {
            return when (name) {
                "aiChat" -> AiChat
                "snippet" -> Snippet
                "quicklink" -> Quicklink
                "raycastNote" -> RaycastNote
                "raycastConfiguration" -> RaycastConfiguration
                "search" -> Search
                "aiCommand" -> AICommand
                else -> throw IllegalArgumentException("Unknown RecordType: $name")
            }
        }
    }
}