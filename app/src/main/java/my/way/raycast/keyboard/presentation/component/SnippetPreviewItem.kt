package my.way.raycast.keyboard.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composeunstyled.Button
import com.composeunstyled.Text
import my.way.raycast.command.domain.model.Command
import my.way.raycast.command.domain.model.CommandType
import my.way.raycast.core.presentation.util.formatRelativeTime
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme
import java.time.Instant
import java.time.LocalDateTime

@Composable
fun SnippetPreviewItem(
    snippet: Command.Snippet,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Button(
        onClick = onClick,
        modifier = modifier,
        backgroundColor = RaycastTheme.colorScheme.fillQuaternary,
        borderColor = RaycastTheme.colorScheme.separatorNonOpaque,
        borderWidth = 1.dp,
        shape = RoundedCornerShape(16.dp),
        contentColor = RaycastTheme.colorScheme.labelPrimary
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = snippet.name,
                    style = RaycastTheme.typography.subheadline,
                    fontFamily = InterFontFamily.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    formatRelativeTime(snippet.accessedAt),
                    style = RaycastTheme.typography.subheadline,
                    fontFamily = InterFontFamily.SemiBold,
                    color = RaycastTheme.colorScheme.labelSecondary
                )
            }

            HorizontalDivider(
                color = RaycastTheme.colorScheme.separatorNonOpaque
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(
                    text = snippet.text,
                    style = RaycastTheme.typography.subheadline,
                    fontFamily = InterFontFamily.SemiBold,
                    modifier = Modifier.fillMaxSize(),
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
private fun SnippetPreviewItemPreview() {
    RaycastTheme(
        darkTheme = true
    ) {
        SnippetPreviewItem(
            snippet = Command.Snippet(
                id = "adfa",
                name = "Test Snippet",
                text = "This is a test snippet",
                accessedAt = LocalDateTime.now(),
                clientUpdatedAt = Instant.now(),
                createdAt = Instant.now(),
                updatedAt = Instant.now(),
                kind = CommandType.Snippet,
                version = 1,
                alias = "",
                category = "General",
                copyCount = 5,
                createdAtLocal = LocalDateTime.now(),
                modifiedAt = LocalDateTime.now()
            ),
            onClick = {},
            modifier = Modifier
                .width(170.dp)
                .height(150.dp),
        )
    }
}
