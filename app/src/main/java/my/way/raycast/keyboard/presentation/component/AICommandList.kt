package my.way.raycast.keyboard.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composeunstyled.Button
import com.composeunstyled.Icon
import com.composeunstyled.Text
import my.way.raycast.R
import my.way.raycast.command.domain.model.Command
import my.way.raycast.icon.RaycastIcons
import my.way.raycast.icon.SparklesTwo
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme

@Composable
fun AICommandList(
    commands: List<Command.AICommand>,
    modifier: Modifier = Modifier,
    onAiCOmmandSelected: (Command.AICommand) -> Unit
) {
    LazyHorizontalGrid(
        modifier = Modifier.fillMaxWidth(),
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            AskAIButton()
        }
        items(commands.sortedByDescending { it.accessedAt }) {
            GridItem(
                it.title,
                image = R.drawable.ic_ai_command,
                onClick = { onAiCOmmandSelected(it) }
            )
        }
    }
}

@Composable
private fun AskAIButton() {
    Button(
        onClick = {},
        borderColor = RaycastTheme.colorScheme.separatorOpaque,
        borderWidth = 1.dp,
        backgroundColor = RaycastTheme.colorScheme.fillQuaternary,
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(vertical = 8.dp),
        modifier = Modifier.width(88.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                2.dp,
                Alignment.CenterVertically
            ),
        ) {
            Icon(
                imageVector = RaycastIcons.SparklesTwo,
                contentDescription = "Ask AI"
            )
            Text(
                "Ask AI",
                style = RaycastTheme.typography.subheadline,
                fontFamily = InterFontFamily.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}