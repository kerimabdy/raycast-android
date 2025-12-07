package my.way.raycast.keyboard.presentation

import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import my.way.raycast.keyboard.presentation.component.AICommandResponse
import my.way.raycast.keyboard.presentation.component.MainLayout
import my.way.raycast.keyboard.presentation.util.LocalInputMethodService
import my.way.raycast.keyboard.presentation.util.deleteText
import my.way.raycast.keyboard.presentation.util.getSelectedOrAllText
import my.way.raycast.keyboard.presentation.util.replaceText
import my.way.raycast.ui.theme.RaycastTheme
import org.koin.androidx.compose.koinViewModel

class MyKeyboardService : ComposeInputMethodService() {

    @Composable
    override fun KeyboardContent() {
        // Now this works because the Service provides the StoreOwner!
        val viewModel = koinViewModel<KeyboardViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()

        val ime = LocalInputMethodService.current
        RaycastTheme {
            KeyboardContainer(
                state = state,
                onAction = { action ->
                    when (action) {

                        is KeyboardAction.OnAddSpace -> ime.currentInputConnection.commitText(
                            " ",
                            1
                        )

                        is KeyboardAction.OnBackspace -> ime.currentInputConnection.deleteText()

                        is KeyboardAction.OnReturn -> {
                            ime.currentInputConnection.commitText(
                                "\n",
                                1
                            )
                        }

                        is KeyboardAction.OnInsertAiResponse -> {
                            ime.currentInputConnection.commitText(
                                action.text,
                                1
                            )
                        }

                        is KeyboardAction.OnReplaceWithAiResponse -> {
                            ime.currentInputConnection.replaceText(action.text)
                        }
                        else -> {}
                    }
                    viewModel.onAction(action)
                }
            )
        }
    }
}


@Composable
fun KeyboardContainer(
    state: KeyboardState,
    onAction: (action: KeyboardAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    val ime = LocalInputMethodService.current
    Box(
        modifier
            .background(RaycastTheme.colorScheme.gray5)
            .height(350.dp)
            .fillMaxWidth()
            .navigationBarsPadding(),
    ) {
        when {
            state.selectedAiCommand != null -> AICommandResponse(
                isLoadings = state.makingAIRequest,
                content = state.aiResponse ?: "",
                selectedAiCommand = state.selectedAiCommand,
                onNavigateBack = { onAction(KeyboardAction.OnNavigateBackToMain) },
                onRetry = { },
                onCopyToClipboard = { },
                onInsert = { text -> onAction(KeyboardAction.OnInsertAiResponse(text)) },
                onReplace = { text -> onAction(KeyboardAction.OnReplaceWithAiResponse(text)) },
            )

            else -> MainLayout(
                state,
                onTabSelected = { tab -> onAction(KeyboardAction.OnTabSelected(tab)) },
                onAiCommandSelected = { command ->
                    onAction(
                        KeyboardAction.OnAiCommandSelected(
                            command,
                            ime.currentInputConnection.getSelectedOrAllText()
                        )
                    )
                },
                onInsertSnippet = { snippetText ->
                    onAction(
                        KeyboardAction.OnInsertAiResponse(
                            snippetText
                        )
                    )
                },
                onInsertQuicklink = { quicklinkText ->
                    onAction(
                        KeyboardAction.OnInsertAiResponse(
                            quicklinkText
                        )
                    )
                },
                onAddSpace = { onAction(KeyboardAction.OnAddSpace) },
                onBackspace = { onAction(KeyboardAction.OnBackspace) },
                onReturn = { onAction(KeyboardAction.OnReturn) }
            )
        }
    }
}

@Preview
@Composable
private fun KeyboardContainerPreview() {
    RaycastTheme(darkTheme = true) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            KeyboardContainer(
                state = KeyboardState(),
                onAction = { }
            )
        }
    }
}