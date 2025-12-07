package my.way.raycast.launcher.presentation

import android.util.Log
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import my.way.raycast.launcher.presentation.util.toSearchItem
import my.way.raycast.command.domain.repository.CommandRepository

class LauncherViewModel(
    private val commandRepository: CommandRepository,
) : ViewModel() {
    var observeCommandsJob: Job? = null
    private var _state = MutableStateFlow(LauncherUiState())
    val state = _state.onStart {
        observeCommands()
        commandRepository.syncCommands()
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        initialValue = _state.value,
    )
    val searchQuery = TextFieldState()

    init {
        viewModelScope.launch {
            observerSearchQuery()
        }
    }

    fun onAction(action: LauncherAction) {
        when (action) {
            is LauncherAction.OnAppsLoaded -> addApps(action.apps)
            is LauncherAction.OnContactsLoaded -> addContacts(action.contacts)
        }
    }

    private fun addApps(apps: List<SearchItem.App>) {
        _state.update {
            it.copy(
                searchItems = listOf(it.searchItems + apps).flatten()
            )
        }
    }

    private fun addContacts(contacts: List<SearchItem.Contacts>) {
        Log.d("LauncherViewModel", "addContacts: $contacts")
        _state.update {
            it.copy(
                searchItems = listOf(it.searchItems + contacts).flatten()
            )
        }
    }

    private fun observeCommands() {
        observeCommandsJob?.cancel()
        observeCommandsJob = commandRepository.getKeyboardCommands().onEach {
            val searchCommands = it.map { command ->
                command.toSearchItem()
            }
            _state.update {
                it.copy(
                    searchItems = listOf(it.searchItems + searchCommands).flatten()
                )
            }
        }.launchIn(viewModelScope)
    }

    private suspend fun observerSearchQuery() {
        snapshotFlow { searchQuery.text }
            .debounce(100)
            .distinctUntilChanged()
            .collectLatest { query ->
                when {
                    query.isBlank() -> {
                        _state.update {
                            it.copy(
                                searchResults = emptyList()
                            )
                        }
                    }

                    query.length >= 2 -> {
                        _state.update {
                            it.copy(
                                searchResults = it.searchItems
                                    .filter { searchItem ->
                                    searchItem.name.lowercase()
                                        .contains(query.toString())
                                }
                            )
                        }
                    }
                }
                Log.d("LauncherViewModel", "searchResults: ${state.value.searchResults}")
            }
    }
}