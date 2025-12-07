package my.way.raycast.launcher.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.composeunstyled.Button
import com.composeunstyled.Icon
import com.composeunstyled.Text
import my.way.raycast.launcher.presentation.SearchItem
import my.way.raycast.icon.ArrowShareRight
import my.way.raycast.icon.BubbleAnnotation5
import my.way.raycast.icon.Call
import my.way.raycast.icon.ChevronLargeRight
import my.way.raycast.icon.RaycastIcons
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme

@Composable
fun SearchResultList(
    searchResults: List<SearchItem>,
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .graphicsLayer {
                compositingStrategy = CompositingStrategy.Offscreen
            }
            .drawWithContent {
                drawContent()

                val feather = 32.dp.toPx()

                // Top fade
                drawRect(
                    topLeft = Offset(0f, 0f),
                    size = Size(size.width, feather),
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 0f,
                        endY = feather
                    ),
                    blendMode = BlendMode.DstIn
                )

                // Bottom fade
                drawRect(
                    topLeft = Offset(0f, size.height - feather),
                    size = Size(size.width, feather),
                    brush = Brush.verticalGradient(
                        0f to Color.Black,
                        1f to Color.Transparent,
                        startY = size.height - feather,
                        endY = size.height
                    ),
                    blendMode = BlendMode.DstIn
                )
            },
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
        contentPadding = PaddingValues(16.dp),
        reverseLayout = true
    ) {
        items(searchResults) {
            when (it) {
                is SearchItem.App -> {
                    CommandListItem(
                        it, onClick = { it.openApp(context) },
                        actions = {
                            Button(
                                onClick = { it.openApp(context) },
                                shape = CircleShape,
                                backgroundColor = RaycastTheme.colorScheme.fillQuaternary,
                                contentColor = RaycastTheme.colorScheme.labelSecondary,
                                contentPadding = PaddingValues(
                                    vertical = 8.dp,
                                    horizontal = 4.dp
                                )
                            ) {
                                Text(
                                    "Open",
                                    style = RaycastTheme.typography.callout,
                                    fontFamily = InterFontFamily.Medium,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                                Icon(
                                    imageVector = RaycastIcons.ChevronLargeRight,
                                    contentDescription = "Open app"
                                )
                            }
                        },
                    )
                }

                is SearchItem.Command -> {
                    CommandListItem(
                        it,
                        onClick = {}, {})
                }

                is SearchItem.Contacts -> {
                    CommandListItem(
                        it,
                        onClick = { it.openContact(context) },
                        actions = {
                            Button(
                                onClick = { it.callContact(context) },
                                shape = CircleShape,
                                backgroundColor = RaycastTheme.colorScheme.fillQuaternary,
                                contentColor = RaycastTheme.colorScheme.labelSecondary,
                                contentPadding = PaddingValues(8.dp)
                            ) {
                                Icon(
                                    imageVector = RaycastIcons.Call,
                                    contentDescription = "Call contact"
                                )
                            }
                            Button(
                                onClick = { it.sendSms(context) },
                                shape = CircleShape,
                                backgroundColor = RaycastTheme.colorScheme.fillQuaternary,
                                contentColor = RaycastTheme.colorScheme.labelSecondary,
                                contentPadding = PaddingValues(8.dp)
                            ) {
                                Icon(
                                    imageVector = RaycastIcons.BubbleAnnotation5,
                                    contentDescription = "Message contact"
                                )
                            }
                            Button(
                                onClick = { it.shareContact(context) },
                                shape = CircleShape,
                                backgroundColor = RaycastTheme.colorScheme.fillQuaternary,
                                contentColor = RaycastTheme.colorScheme.labelSecondary,
                                contentPadding = PaddingValues(8.dp)
                            ) {
                                Icon(
                                    imageVector = RaycastIcons.ArrowShareRight,
                                    contentDescription = "Share contact"
                                )
                            }
                        },
                    )
                }
            }
        }

    }
}