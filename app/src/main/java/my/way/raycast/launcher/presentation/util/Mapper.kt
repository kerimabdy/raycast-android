package my.way.raycast.launcher.presentation.util

import my.way.raycast.R
import my.way.raycast.launcher.presentation.SearchItem
import my.way.raycast.command.domain.model.Command

fun Command.toSearchItem(): SearchItem.Command {
    return when(this) {
        is Command.AICommand -> {
            SearchItem.Command(
                name = this.title,
                iconUri = R.drawable.ic_ai_command,
            )
        }
        is Command.Quicklink -> SearchItem.Command(
            name = this.name,
            iconUri = R.drawable.ic_quicklink,
        )
        is Command.Snippet -> {
            SearchItem.Command(
                name = this.name,
                iconUri = R.drawable.ic_snippet,
            )
        }
        is Command.Unknown -> {
            error("Unknown command type")
        }
    }
}