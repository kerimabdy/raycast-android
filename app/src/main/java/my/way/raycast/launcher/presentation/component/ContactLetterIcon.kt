package my.way.raycast.launcher.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme
import kotlin.math.abs

@Composable
fun ContactLetterIcon(
    name: String,
    modifier: Modifier = Modifier,
) {
    val letter = name.firstOrNull()?.uppercaseChar() ?: '#'

    val colors = listOf(
        Color(0xFFF44336), Color(0xFFE91E63), Color(0xFF9C27B0), Color(0xFF673AB7),
        Color(0xFF3F51B5), Color(0xFF2196F3), Color(0xFF03A9F4), Color(0xFF00BCD4),
        Color(0xFF009688), Color(0xFF4CAF50), Color(0xFF8BC34A), Color(0xFFCDDC39),
        Color(0xFFFFEB3B), Color(0xFFFFC107), Color(0xFFFF9800), Color(0xFFFF5722)
    )
    val backgroundColor = colors[abs(name.hashCode()) % colors.size]

    Box(
        modifier = modifier.background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = letter.toString(),
            color = Color.White,
            style = RaycastTheme.typography.title1,
            fontFamily = InterFontFamily.Medium
        )
    }
}