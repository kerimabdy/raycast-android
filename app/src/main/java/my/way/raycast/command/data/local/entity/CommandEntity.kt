package my.way.raycast.command.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
data class CommandEntity(
    @PrimaryKey val id: String,
    val clientUpdatedAt: String,
    val createdAt: String,
    val kind: String,
    val updatedAt: String,
    val value: String,
    val version: Int,
)
