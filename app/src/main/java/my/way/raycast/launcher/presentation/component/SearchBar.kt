package my.way.raycast.launcher.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.composeunstyled.Button
import com.composeunstyled.Icon
import com.composeunstyled.Text
import com.composeunstyled.TextField
import com.composeunstyled.TextInput
import my.way.raycast.icon.CrossSmall
import my.way.raycast.icon.RaycastIcons
import my.way.raycast.ui.theme.RaycastTheme

@Composable
fun SearchBar(
    state: TextFieldState,
    modifier: Modifier = Modifier,
) {
    TextField(
        modifier = modifier,
        state = state,
        cursorBrush = SolidColor(RaycastTheme.colorScheme.brandColorRed),
        singleLine = true,
        textStyle = RaycastTheme.typography.body,
        textColor = RaycastTheme.colorScheme.labelPrimary,
    ) {
        TextInput(
            modifier = Modifier.height(56.dp),
            shape = RoundedCornerShape(32.dp),
            backgroundColor = RaycastTheme.colorScheme.gray6,
            contentPadding = PaddingValues(start = 16.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
            placeholder = {
                Text(
                    "Search for apps and commands",
                    style = RaycastTheme.typography.body,
                    color = RaycastTheme.colorScheme.labelTertiary,
                )
            },
            trailing = {
                if (state.text.isNotBlank()) {
                    Button(
                        onClick = { state.clearText() },
                        shape = CircleShape,
                        backgroundColor = RaycastTheme.colorScheme.fillQuaternary,
                        contentColor = RaycastTheme.colorScheme.labelSecondary,
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        Icon(
                            imageVector = RaycastIcons.CrossSmall,
                            contentDescription = "Clear text"
                        )
                    }
                }
            }
        )
    }
}