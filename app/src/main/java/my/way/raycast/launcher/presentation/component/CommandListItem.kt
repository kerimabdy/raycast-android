package my.way.raycast.launcher.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import my.way.raycast.launcher.presentation.SearchItem
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme


@Composable
fun CommandListItem(
    command: SearchItem.Command,
    onClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
) {
    CommandListItemRoot(
        title = command.name,
        onClick = onClick,
        image = {
            AsyncImage(
                model = command.iconUri,
                contentDescription = command.name,
                modifier = Modifier.size(40.dp)
            )
        },
        actions = actions,
        modifier = modifier
    )
}

@Composable
fun CommandListItem(
    app: SearchItem.App,
    onClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
) {
    CommandListItemRoot(
        title = app.name,
        onClick = onClick,
        image = {
            AsyncImage(
                model = app.icon,
                contentDescription = app.name,
                modifier = Modifier.size(40.dp)
            )
        },
        actions = actions,
        modifier = modifier
    )
}

@Composable
fun CommandListItem(
    contact: SearchItem.Contacts,
    onClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
) {
    CommandListItemRoot(
        title = contact.name,
        onClick = onClick,
        image = {
            if (contact.photoUri != null) {
                AsyncImage(
                    model = contact.photoUri,
                    contentDescription = contact.name,
                    modifier = Modifier.size(40.dp)
                )
            } else {
                ContactLetterIcon(
                    name = contact.name,
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        actions = actions,
        modifier = modifier
    )
}

@Composable
private fun CommandListItemRoot(
    title: String,
    onClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    image: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    SwipeableItemWithActions(
        isRevealed = false,
        actions = actions
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .clickable(onClick = onClick)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier.clip(RoundedCornerShape(12.dp))
            ) {
                image()
            }

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = title,
                style = RaycastTheme.typography.callout,
                fontFamily = InterFontFamily.Medium,
                color = RaycastTheme.colorScheme.labelPrimary
            )
        }
    }

}