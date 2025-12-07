package my.way.raycast.keyboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import my.way.raycast.ai.domain.model.StreamEvent
import my.way.raycast.ai.domain.repository.AIRepository
import my.way.raycast.command.domain.model.Command
import my.way.raycast.command.domain.repository.CommandRepository
import my.way.raycast.core.domain.util.onSuccess
import my.way.raycast.keyboard.presentation.util.toAiRequest

class KeyboardViewModel(
    private val commandRepository: CommandRepository,
    private val aiRepository: AIRepository,
) : ViewModel() {
    private var observeCommandsJob: Job? = null
    private var streamAiResponseJob: Job? = null
    private val _state = MutableStateFlow(KeyboardState())
    val state = _state.onStart {
        observeCommands()
        commandRepository.syncCommands()
    }.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = _state.value
    )


    fun onAction(action: KeyboardAction) {
        when (action) {
            KeyboardAction.OnBackspace -> {}
            KeyboardAction.OnReturn -> {}
            KeyboardAction.OnAddSpace -> {}
            is KeyboardAction.OnAiCommandSelected -> {
                makeAiRequest(action.command, action.text)
            }
            is KeyboardAction.OnTabSelected -> updateSelectedTab(action)
            is KeyboardAction.OnNavigateBackToMain -> clearAiCommandAndResponse()
            is KeyboardAction.OnInsertAiResponse -> {}
            is KeyboardAction.OnReplaceWithAiResponse -> {}
        }
    }

    private fun clearAiCommandAndResponse() {
        _state.update {
            it.copy(
                selectedAiCommand = null,
                makingAIRequest = false,
                aiResponse = null
            )
        }
    }

    private fun makeAiRequest(aiCommand: Command.AICommand?, text: String) {
        _state.update {
            it.copy(
                selectedAiCommand = aiCommand
            )
        }

        if (aiCommand == null) return

        streamAiResponseJob = null

        _state.update {
            it.copy(
                makingAIRequest = true,
                selectedAiCommand = aiCommand
            )
        }

        var fullText = ""
        streamAiResponseJob = aiRepository.streamResponse(aiCommand.toAiRequest(text)).onEach { streamResult ->
            streamResult.onSuccess { streamEvent ->
                when (streamEvent) {
                    is StreamEvent.Chunk -> {
                        fullText += streamEvent.content
                        _state.update {
                            it.copy(
                                aiResponse = fullText
                            )
                        }
                    }
                    StreamEvent.Finished -> {
                        _state.update {
                            it.copy(
                                makingAIRequest = false,
                            )
                        }
                    }
                }
            }
        }.launchIn(viewModelScope)


    }

    private fun updateSelectedTab(action: KeyboardAction.OnTabSelected) {
        _state.update {
            it.copy(
                selectedTab = action.tab
            )
        }
    }

    private fun observeCommands() {
        observeCommandsJob?.cancel()
        observeCommandsJob = commandRepository.getKeyboardCommands().onEach { commands ->
            _state.value = _state.value.copy(
                commandList = commands
            )
        }.launchIn(viewModelScope)
    }
}