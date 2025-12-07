package my.way.raycast.ai.data.local.databse

import androidx.room.Database
import androidx.room.RoomDatabase
import my.way.raycast.ai.data.local.dao.MessageDao
import my.way.raycast.ai.data.local.entity.MessageEntity

const val DATABASE_NAME = "ai_chat_database"

@Database(
    entities = [MessageEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ChatDatabase: RoomDatabase() {
    abstract fun messageDao(): MessageDao
}