package my.way.raycast.keyboard.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.composeunstyled.Button
import com.composeunstyled.Icon
import com.composeunstyled.Text
import my.way.raycast.command.domain.model.Command
import my.way.raycast.command.domain.model.CommandType
import my.way.raycast.icon.ArrowRetry
import my.way.raycast.icon.Clipboard
import my.way.raycast.icon.IconArrowLeft
import my.way.raycast.icon.RaycastIcons
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme
import java.time.Instant
import java.time.LocalDateTime

@Composable
fun AICommandResponse(
    isLoadings: Boolean,
    content: String,
    selectedAiCommand: Command.AICommand,
    onNavigateBack: () -> Unit,
    onRetry: () -> Unit,
    onCopyToClipboard: (text: String) -> Unit,
    onInsert: (text: String) -> Unit,
    onReplace: (text: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = onNavigateBack,
                contentColor = RaycastTheme.colorScheme.labelSecondary,
                borderColor = RaycastTheme.colorScheme.separatorOpaque,
                borderWidth = 1.dp,
                shape = RoundedCornerShape(24.dp),
                contentPadding = PaddingValues(
                    horizontal = 12.dp,
                    vertical = 8.dp
                )
            ) {
                Icon(
                    imageVector = RaycastIcons.IconArrowLeft,
                    contentDescription = "Back"
                )
            }

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            RaycastTheme.colorScheme.blue,
                            androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                        )
                )
                Text(
                    text = selectedAiCommand.title,
                    style = RaycastTheme.typography.title3,
                    fontFamily = InterFontFamily.SemiBold,
                    color = RaycastTheme.colorScheme.labelPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }

            Button(
                onClick = onRetry,
                contentColor = RaycastTheme.colorScheme.labelSecondary,
                shape = RoundedCornerShape(24.dp),
                contentPadding = PaddingValues(
                    horizontal = 12.dp,
                    vertical = 8.dp
                )
            ) {
                Icon(
                    imageVector = RaycastIcons.ArrowRetry,
                    contentDescription = "Retry"
                )
            }
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp, vertical = 6.dp)
            ) {
                Text(
                    text = content,
                    style = RaycastTheme.typography.title3,
                    fontFamily = InterFontFamily.Medium,
                    color = RaycastTheme.colorScheme.labelPrimary,
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .align(Alignment.TopCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            0.0f to RaycastTheme.colorScheme.gray5,
                            1.0f to RaycastTheme.colorScheme.gray5.copy(alpha = 0f),
                        )
                    )
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            0.0f to RaycastTheme.colorScheme.gray5.copy(alpha = 0f),
                            1.0f to RaycastTheme.colorScheme.gray5,
                        )
                    )
            )
        }


        Row(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { onCopyToClipboard(content) },
                shape = RoundedCornerShape(16.dp),
                backgroundColor = RaycastTheme.colorScheme.primaryBackground,
                contentColor = RaycastTheme.colorScheme.labelPrimary,
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 14.dp)
            ) {
                Icon(
                    imageVector = RaycastIcons.Clipboard,
                    contentDescription = "Clipboard",
                    modifier = Modifier.size(20.dp)
                )
            }
            Button(
                onClick = { onInsert(content) },
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                backgroundColor = RaycastTheme.colorScheme.primaryBackground,
                contentColor = RaycastTheme.colorScheme.labelPrimary,
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp)
            ) {
                Text(
                    "Insert",
                    style = RaycastTheme.typography.title3,
                    fontFamily = InterFontFamily.SemiBold,
                )
            }
            Button(
                onClick = { onReplace(content) },
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                backgroundColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                contentColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp)
            ) {
                Text(
                    "Replace",
                    style = RaycastTheme.typography.title3,
                    fontFamily = InterFontFamily.SemiBold,
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun AiCommandResponsePreview() {
    RaycastTheme {
        Box(
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()
                .background(RaycastTheme.colorScheme.gray5)
        ) {
            AICommandResponse(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                isLoadings = true,
                content = "Hello, World! Давайте более подробно обсудим, что именно мы хотим достичь. Какие цели и задачи стоят перед нами, и как мы можем эффективно двигаться в их направлении? Важно понять, какие шаги необходимо предпринять, чтобы реализовать наши идеи и планы.",
                onNavigateBack = {},
                onRetry = {},
                selectedAiCommand = Command.AICommand(
                    id = "",
                    title = "Hello World brali chto hotim",
                    clientUpdatedAt = Instant.now(),
                    createdAt = Instant.now(),
                    updatedAt = Instant.now(),
                    kind = CommandType.AICommand,
                    version = 1,
                    accessedAt = LocalDateTime.now(),
                    count = 1,
                    createdAtLocal = LocalDateTime.now(),
                    highlightEdits = false,
                    iconName = "",
                    model = "",
                    modifiedAt = LocalDateTime.now(),
                    promptTemplate = "",
                    temperature = 0.4,
                    uuid = "",
                ),
                onCopyToClipboard = { },
                onInsert = { },
                onReplace = { }
            )
        }

    }
}