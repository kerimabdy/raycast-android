package my.way.raycast.ai.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import my.way.raycast.ai.data.local.entity.MessageEntity

@Dao
interface MessageDao {
    @Query("SELECT * FROM message ORDER by timestamp ASC")
    fun getAllMessage(): Flow<List<MessageEntity>>

    @Insert
    suspend fun insertMessage(messageEntity: MessageEntity)
}