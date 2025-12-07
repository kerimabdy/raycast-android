package my.way.raycast.keyboard.presentation.util

import android.inputmethodservice.InputMethodService
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalInputMethodService = staticCompositionLocalOf<InputMethodService> {
    error("CompositionLocal LocalInputMethodService not present")
}