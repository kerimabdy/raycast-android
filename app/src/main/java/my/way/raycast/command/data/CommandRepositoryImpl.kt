package my.way.raycast.command.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import my.way.raycast.command.data.local.dao.CommandDao
import my.way.raycast.command.data.mapper.toDomain
import my.way.raycast.command.data.remote.CommandDataSource
import my.way.raycast.command.domain.model.AiChat
import my.way.raycast.command.domain.model.Command
import my.way.raycast.command.domain.model.Quicklink
import my.way.raycast.command.domain.model.RaycastNote
import my.way.raycast.command.domain.model.Snippet
import my.way.raycast.command.domain.repository.CommandRepository
import my.way.raycast.core.domain.util.onError
import my.way.raycast.core.domain.util.onSuccess

class CommandRepositoryImpl(
    private val commandDataSource: CommandDataSource,
    private val commandDao: CommandDao,
) : CommandRepository {

    override suspend fun syncCommands() {
        commandDataSource.getCommands()
            .onSuccess { commands ->
                commandDao.insertCommands(commands)
            }.onError {
                // Handle error
            }
    }

    override fun getHistory(): Flow<List<Command>> {
        TODO("Not yet implemented")
    }

    override  fun getQuicklinks(): Flow<List<Command>> {
        TODO("Not yet implemented")
    }

    override fun getSnippets(): Flow<List<Snippet>> {
        TODO("Not yet implemented")
    }

    override fun getKeyboardCommands(): Flow<List<Command>> {
        return commandDao.getKeyboardCommands()
            .map { it.map { it.toDomain() } }
    }

    override fun getAiChats(): Flow<List<AiChat>> {
        TODO("Not yet implemented")
    }

    override fun getRaycastNotes(): Flow<List<RaycastNote>> {
        TODO("Not yet implemented")
    }

    override fun getQuicklinkById(id: String): Flow<Quicklink?> {
        TODO("Not yet implemented")
    }

    override fun getSnippetById(id: String): Flow<Snippet?> {
        TODO("Not yet implemented")
    }

    override fun getCommandById(id: String): Flow<Command?> {
        TODO("Not yet implemented")
    }

    override fun getAiChatById(id: String): Flow<AiChat?> {
        TODO("Not yet implemented")
    }

    override fun getRaycastNoteById(id: String): Flow<RaycastNote?> {
        TODO("Not yet implemented")
    }

    override fun saveQuicklink(quicklink: Quicklink) {
        TODO("Not yet implemented")
    }

    override fun saveSnippet(snippet: Snippet) {
        TODO("Not yet implemented")
    }

    override fun saveRecord(command: Command) {
        TODO("Not yet implemented")
    }

    override fun saveAiChat(aiChat: AiChat) {
        TODO("Not yet implemented")
    }

    override fun saveRaycastNote(raycastNote: RaycastNote) {
        TODO("Not yet implemented")
    }
}