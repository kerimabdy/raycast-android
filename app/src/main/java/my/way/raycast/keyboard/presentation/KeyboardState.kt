package my.way.raycast.keyboard.presentation

import androidx.compose.runtime.Immutable
import my.way.raycast.command.domain.model.Command
import my.way.raycast.keyboard.presentation.component.CommandTab

@Immutable
data class KeyboardState(
    val selectedTab: CommandTab = CommandTab.AI,
    val commandList: List<Command> = emptyList(),
    val makingAIRequest: Boolean = false,
    val selectedAiCommand: Command.AICommand? = null,
    val aiResponse: String? = null,
)
