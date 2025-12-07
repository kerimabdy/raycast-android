package my.way.raycast.ai.di

import androidx.room.Room
import io.ktor.client.engine.cio.CIO
import kotlinx.serialization.json.Json
import my.way.raycast.BuildConfig
import my.way.raycast.ai.data.local.dao.MessageDao
import my.way.raycast.ai.data.local.databse.ChatDatabase
import my.way.raycast.ai.data.local.databse.DATABASE_NAME
import my.way.raycast.ai.data.remote.api.GrokApiService
import my.way.raycast.ai.data.repository.AIRepositoryImpl
import my.way.raycast.ai.domain.repository.AIRepository
import my.way.raycast.ai.domain.usecase.SendMessageUseCase
import my.way.raycast.core.data.networking.HttpClientFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val aiChatModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            ChatDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    single<MessageDao> {
        get<ChatDatabase>().messageDao()
    }

    singleOf(::AIRepositoryImpl).bind<AIRepository>()

    single { provideJson() }
    single { HttpClientFactory.create(CIO.create()) }
    single { GrokApiService(get(), BuildConfig.XAI_API_KEY) }

    factory { SendMessageUseCase(get()) }  // Add GetMessagesUseCase similarly


}

private fun provideJson(): Json = Json { ignoreUnknownKeys = true }