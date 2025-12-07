package my.way.raycast.command.data.local.data_store

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.networkDataStore by preferencesDataStore(name = "network_data_store")


class NeworkDataStoreImpl(
    val context: Context,
) : NetworkDataStore {
    private val networkDataStore = context.networkDataStore

    companion object Companion {
        private val LAST_UPDATE_DATE = stringPreferencesKey("last_update_date")
    }

    override suspend fun updateLastUpdateDate(updatedAtString: String) {
        networkDataStore.edit {
            it[LAST_UPDATE_DATE] = updatedAtString
        }
    }

    override suspend fun getLastUpdateDate(): String? {
        return networkDataStore.data.map {
            it[LAST_UPDATE_DATE]
        }.first()

    }
}