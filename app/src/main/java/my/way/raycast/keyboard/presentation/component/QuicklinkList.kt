package my.way.raycast.keyboard.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import my.way.raycast.R
import my.way.raycast.command.domain.model.Command

@Composable
fun QuicklinkList(
    quicklinks: List<Command.Quicklink>,
    modifier: Modifier = Modifier,
    onInsertQuicklink: (text: String) -> Unit,
) {
    LazyHorizontalGrid(
        modifier = Modifier.fillMaxWidth(),
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {

        items(quicklinks.sortedByDescending { it.updatedAtLocal }) {
            GridItem(
                text = it.name,
                image = R.drawable.ic_quicklink,
                onClick = { onInsertQuicklink(it.urlString) }
            )
        }
    }
}