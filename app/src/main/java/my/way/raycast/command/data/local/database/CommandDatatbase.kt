package my.way.raycast.command.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import my.way.raycast.command.data.local.dao.CommandDao
import my.way.raycast.command.data.local.entity.CommandEntity


const val DATABASE_NAME = "command_database"

@Database(
    entities = [CommandEntity::class],
    version = 1,
    exportSchema = false
)

abstract class CommandDatabase: RoomDatabase() {
    abstract fun commandDao(): CommandDao
}