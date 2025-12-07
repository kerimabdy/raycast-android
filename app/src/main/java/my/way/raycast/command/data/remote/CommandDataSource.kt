package my.way.raycast.command.data.remote

import my.way.raycast.command.data.local.entity.CommandEntity
import my.way.raycast.core.domain.util.NetworkError
import my.way.raycast.core.domain.util.Result

interface CommandDataSource {
    suspend fun getCommands(): Result<List<CommandEntity>, NetworkError>
}