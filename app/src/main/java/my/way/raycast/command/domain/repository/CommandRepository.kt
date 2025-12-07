package my.way.raycast.command.domain.repository

import kotlinx.coroutines.flow.Flow
import my.way.raycast.command.domain.model.AiChat
import my.way.raycast.command.domain.model.Quicklink
import my.way.raycast.command.domain.model.RaycastNote
import my.way.raycast.command.domain.model.Snippet
import my.way.raycast.command.domain.model.Command

interface CommandRepository {
    suspend fun syncCommands()

    fun getHistory(): Flow<List<Command>>
    fun getQuicklinks(): Flow<List<Command>>
    fun getSnippets(): Flow<List<Snippet>>
    fun getKeyboardCommands(): Flow<List<Command>>
    fun getAiChats(): Flow<List<AiChat>>
    fun getRaycastNotes(): Flow<List<RaycastNote>>

    fun getQuicklinkById(id: String): Flow<Quicklink?>
    fun getSnippetById(id: String): Flow<Snippet?>
    fun getCommandById(id: String): Flow<Command?>
    fun getAiChatById(id: String): Flow<AiChat?>
    fun getRaycastNoteById(id: String): Flow<RaycastNote?>

    fun saveQuicklink(quicklink: Quicklink)
    fun saveSnippet(snippet: Snippet)
    fun saveRecord(command: Command)
    fun saveAiChat(aiChat: AiChat)
    fun saveRaycastNote(raycastNote: RaycastNote)
}