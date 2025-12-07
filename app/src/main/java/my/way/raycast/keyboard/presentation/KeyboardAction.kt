package my.way.raycast.keyboard.presentation

import my.way.raycast.command.domain.model.Command
import my.way.raycast.keyboard.presentation.component.CommandTab

sealed interface KeyboardAction {
    data class OnAiCommandSelected(val command: Command.AICommand?, val text: String): KeyboardAction
    object OnNavigateBackToMain: KeyboardAction
    data class OnInsertAiResponse(val text: String): KeyboardAction
    data class OnReplaceWithAiResponse(val text: String): KeyboardAction
    data class OnTabSelected(val tab: CommandTab): KeyboardAction
    object OnAddSpace: KeyboardAction
    object OnBackspace: KeyboardAction
    object OnReturn: KeyboardAction
}
