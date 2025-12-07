package my.way.raycast.command.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CommandsResponseDto(
    val updated: List<CommandDto>,
    @SerialName("updated_at") val updatedAt: String,
)


@Serializable
data class CommandDto(
    @SerialName("client_updated_at") val clientUpdatedAt: String,
    @SerialName("created_at") val createdAt: String,
    val id: String,
    val kind: String,
    @SerialName("updated_at") val updatedAt: String,
    val value: String,
    val version: Int,
)
