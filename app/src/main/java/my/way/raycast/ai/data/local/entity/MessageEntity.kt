package my.way.raycast.ai.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val content: String,
    val isUser: Boolean,
    val timestamp: Long
)
