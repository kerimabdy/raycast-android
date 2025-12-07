package my.way.raycast.keyboard.di

import my.way.raycast.keyboard.presentation.KeyboardViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val keyboardModule = module {
    viewModelOf(::KeyboardViewModel)
}