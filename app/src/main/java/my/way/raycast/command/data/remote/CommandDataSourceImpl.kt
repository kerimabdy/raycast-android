package my.way.raycast.command.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import my.way.raycast.BuildConfig
import my.way.raycast.command.data.local.data_store.NetworkDataStore
import my.way.raycast.command.data.local.entity.CommandEntity
import my.way.raycast.command.data.remote.dto.CommandsResponseDto
import my.way.raycast.command.data.mapper.toEntity
import my.way.raycast.core.data.networking.safeCall
import my.way.raycast.core.domain.util.NetworkError
import my.way.raycast.core.domain.util.Result
import my.way.raycast.core.domain.util.map

class CommandDataSourceImpl(
    private val client: HttpClient,
    private val syncDataStore: NetworkDataStore
) : CommandDataSource {
    override suspend fun getCommands(): Result<List<CommandEntity>, NetworkError> {
        val lastUpdatedDate = syncDataStore.getLastUpdateDate()

        return safeCall<CommandsResponseDto> {
            client.get(
                "https://backend.raycast.com/api/v1/me/sync"
            ) {
                header("User-Agent", "Raycast/1.103.9 (macOS Version 15.6 (Build 24G84))")
                header("Authorization", "Bearer ${BuildConfig.RAYCAST_TOKEN}")
                header(
                    "X-Raycast-Signature",
                    BuildConfig.RAYCAST_SIGNATURE
                )
                lastUpdatedDate?.let {
                    parameter("after", it)
                }
            }
        }.map { response ->
            syncDataStore.updateLastUpdateDate(
                response.updatedAt
            )
            response.updated.map { it.toEntity() }
        }
    }
}