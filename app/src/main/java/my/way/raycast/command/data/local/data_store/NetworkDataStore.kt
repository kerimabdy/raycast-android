package my.way.raycast.command.data.local.data_store


interface NetworkDataStore {
    suspend fun updateLastUpdateDate(updatedAtString: String)
    suspend fun getLastUpdateDate(): String?
}