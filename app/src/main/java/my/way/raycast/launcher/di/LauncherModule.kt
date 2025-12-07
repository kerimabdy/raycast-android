package my.way.raycast.launcher.di

import my.way.raycast.launcher.presentation.LauncherViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val launcherModule = module {
    viewModelOf(::LauncherViewModel)
}