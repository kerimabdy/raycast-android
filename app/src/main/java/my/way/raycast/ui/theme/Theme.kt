package my.way.raycast.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle


@Composable
fun RaycastTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customTextSelectionColors = TextSelectionColors(
        handleColor = colorScheme.brandColorRed,
        backgroundColor = colorScheme.brandColorRed.copy(alpha = 0.4f)
    )

    CompositionLocalProvider(
        LocalRaycastColors provides colorScheme,
        LocalRaycastTypography provides raycastTypography,
        LocalContentColor provides colorScheme.labelPrimary,
        LocalTextStyle provides raycastTypography.body,
        LocalTextSelectionColors provides customTextSelectionColors
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object RaycastTheme {
    val colorScheme: RaycastColors
        @Composable
        get() = LocalRaycastColors.current

    val typography: RaycastTypography
        @Composable
        get() = LocalRaycastTypography.current
}