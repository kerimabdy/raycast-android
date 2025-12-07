package my.way.raycast.command.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import my.way.raycast.command.data.local.entity.CommandEntity


@Dao
interface CommandDao {
    @Query("SELECT * FROM CommandEntity")
    fun getAllCommands(): Flow<List<CommandEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCommands(commands: List<CommandEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCommand(command: CommandEntity)

    @Query("SELECT * FROM CommandEntity WHERE kind = 'quicklink' or kind = 'snippet' or kind = 'aiCommand'")
    fun getKeyboardCommands(): Flow<List<CommandEntity>>
}