package my.way.raycast.keyboard.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import my.way.raycast.command.domain.model.Command

@Composable
fun SnippetList(
    snippets: List<Command.Snippet>,
    modifier: Modifier = Modifier,
    onInsertSnippet: (text: String) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)

    ) {
        items(snippets.sortedByDescending { it.accessedAt }) {
            SnippetPreviewItem(
                onClick = { onInsertSnippet(it.text) },
                snippet = it,
                modifier = Modifier.width(170.dp)
            )
        }
    }
}