package my.way.raycast.di

import android.content.Context
import my.way.raycast.ai.di.aiChatModule
import my.way.raycast.launcher.di.launcherModule
import my.way.raycast.command.di.commandModule
import my.way.raycast.keyboard.di.keyboardModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

fun startKoinWithModules(
    context: Context
) {
    startKoin {
        androidContext(context)
        androidLogger()
        modules(aiChatModule, commandModule, keyboardModule, launcherModule)
    }
}