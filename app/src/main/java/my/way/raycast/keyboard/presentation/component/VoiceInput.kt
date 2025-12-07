package my.way.raycast.keyboard.presentation.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composeunstyled.Button
import com.composeunstyled.Icon
import com.composeunstyled.Text
import my.way.raycast.icon.RaycastIcons
import my.way.raycast.icon.SparklesTwo
import my.way.raycast.icon.Voice1
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme

@Composable
fun VoiceInput(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 8.dp, bottom = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            val backgroundColor = if (isSystemInDarkTheme()) Color.White else Color.Black
            val contentColor = if (isSystemInDarkTheme()) Color.Black else Color.White

            Button(
                onClick = {},
                shape = CircleShape,
                backgroundColor = backgroundColor,
                contentColor = contentColor,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            ) {
                Icon(
                    imageVector = RaycastIcons.Voice1,
                    contentDescription = "Voice input",
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = RaycastIcons.SparklesTwo,
                    contentDescription = "Voice input",
                    tint = RaycastTheme.colorScheme.labelSecondary
                )
            }
            LazyRow(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(24.dp),
                        borderColor = RaycastTheme.colorScheme.separatorOpaque,
                        borderWidth = 1.dp,
                        contentColor = RaycastTheme.colorScheme.labelSecondary,
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    ) {
                        Text(
                            "Email",
                            style = RaycastTheme.typography.callout,
                            fontFamily = InterFontFamily.SemiBold
                        )
                    }
                }
                item {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(24.dp),
                        borderColor = RaycastTheme.colorScheme.separatorOpaque,
                        borderWidth = 1.dp,
                        contentColor = RaycastTheme.colorScheme.labelSecondary,
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    ) {
                        Text(
                            "Notes",
                            style = RaycastTheme.typography.callout,
                            fontFamily = InterFontFamily.SemiBold
                        )
                    }
                }
                item {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(24.dp),
                        borderColor = RaycastTheme.colorScheme.separatorOpaque,
                        borderWidth = 1.dp,
                        contentColor = RaycastTheme.colorScheme.labelSecondary,
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    ) {
                        Text(
                            "AI Command",
                            style = RaycastTheme.typography.callout,
                            fontFamily = InterFontFamily.SemiBold
                        )
                    }
                }
            }
        }
    }
}