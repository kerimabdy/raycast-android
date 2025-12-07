package my.way.raycast.command.di

import androidx.room.Room
import my.way.raycast.command.data.CommandRepositoryImpl
import my.way.raycast.command.data.local.dao.CommandDao
import my.way.raycast.command.data.local.data_store.NetworkDataStore
import my.way.raycast.command.data.local.data_store.NeworkDataStoreImpl
import my.way.raycast.command.data.local.database.CommandDatabase
import my.way.raycast.command.data.local.database.DATABASE_NAME
import my.way.raycast.command.data.remote.CommandDataSource
import my.way.raycast.command.data.remote.CommandDataSourceImpl
import my.way.raycast.command.domain.repository.CommandRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val commandModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            CommandDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    single<CommandDao> {
        get<CommandDatabase>().commandDao()
    }
    singleOf(::NeworkDataStoreImpl).bind<NetworkDataStore>()
    singleOf(::CommandRepositoryImpl).bind<CommandRepository>()
    singleOf(::CommandDataSourceImpl).bind<CommandDataSource>()
}