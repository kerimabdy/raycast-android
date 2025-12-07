package my.way.raycast.keyboard.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composeunstyled.Button
import com.composeunstyled.Icon
import com.composeunstyled.Tab
import com.composeunstyled.TabGroup
import com.composeunstyled.TabList
import com.composeunstyled.Text
import my.way.raycast.command.domain.model.Command
import my.way.raycast.icon.ArrowCornerDownLeft
import my.way.raycast.icon.ArrowLeftX
import my.way.raycast.icon.MagnifyingGlass2
import my.way.raycast.icon.RaycastIcons
import my.way.raycast.keyboard.presentation.KeyboardState
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme

@Composable
fun MainLayout(
    state: KeyboardState,
    onTabSelected: (CommandTab) -> Unit,
    onAiCommandSelected: (Command.AICommand) -> Unit,
    onInsertSnippet: (text: String) -> Unit,
    onInsertQuicklink: (text: String) -> Unit,
    onAddSpace: () -> Unit,
    onBackspace: () -> Unit,
    onReturn: () -> Unit,
) {
    Column(
    ) {
        TabGroup(
            selectedTab = state.selectedTab.key,
            modifier = Modifier.Companion
                .weight(1f)
                .fillMaxWidth(),
            tabs = commandTabKeyList.map { it.key },
        ) {
            TabList(
                modifier = Modifier.Companion
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Companion.CenterVertically,
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    commandTabKeyList.forEach { tab ->
                        val isSelected = state.selectedTab == tab
                        Tab(
                            key = tab.key,
                            selected = isSelected,
                            onSelected = { onTabSelected(tab) },
                            contentPadding = PaddingValues(
                                horizontal = 10.dp,
                                vertical = 6.dp
                            ),
                            modifier = Modifier.Companion,
                            shape = RoundedCornerShape(24.dp),
                            backgroundColor = if (isSelected) RaycastTheme.colorScheme.fillQuaternary else Color.Companion.Unspecified,
                            contentColor = if (isSelected) RaycastTheme.colorScheme.labelPrimary else RaycastTheme.colorScheme.labelSecondary,
                        ) {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.key
                            )
                        }
                    }
                }
                Button(
                    onClick = { },
                    contentColor = RaycastTheme.colorScheme.labelPrimary,
                    contentPadding = PaddingValues(
                        horizontal = 10.dp,
                        vertical = 6.dp
                    ),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(24.dp),
                    modifier = Modifier.Companion,
                ) {
                    Icon(
                        imageVector = RaycastIcons.MagnifyingGlass2,
                        contentDescription = "Search"
                    )
                }
            }
            TabContentWrapper(
                modifier = Modifier.Companion
                    .fillMaxWidth()
                    .weight(1f),
                contentColor = RaycastTheme.colorScheme.labelPrimary
            ) {
                when (state.selectedTab) {
                    CommandTab.Snippet -> SnippetList(
                        snippets = state.commandList.filterIsInstance<Command.Snippet>(),
                        onInsertSnippet = onInsertSnippet
                    )

                    CommandTab.AI -> AICommandList(
                        commands = state.commandList.filterIsInstance<Command.AICommand>(),
                        onAiCOmmandSelected = onAiCommandSelected
                    )

                    CommandTab.QuickLink -> QuicklinkList(
                        quicklinks = state.commandList.filterIsInstance<Command.Quicklink>(),
                        onInsertQuicklink = onInsertQuicklink
                    )

                    CommandTab.Voice -> VoiceInput()
                }
            }
        }

        Row(
            modifier = Modifier.Companion
                .padding(top = 16.dp, bottom = 32.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {
            Button(
                onClick = onAddSpace,
                modifier = Modifier.Companion
                    .height(48.dp)
                    .weight(1f),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                backgroundColor = RaycastTheme.colorScheme.fillTertiary,
                contentColor = RaycastTheme.colorScheme.labelPrimary,
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp)
            ) {
                Text(
                    "space",
                    style = RaycastTheme.typography.subheadline,
                    fontFamily = InterFontFamily.SemiBold,
                )
            }
            Button(
                onClick = onBackspace,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                backgroundColor = RaycastTheme.colorScheme.fillTertiary,
                contentColor = RaycastTheme.colorScheme.labelPrimary,
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 12.dp)
            ) {
                Icon(
                    imageVector = RaycastIcons.ArrowLeftX,
                    contentDescription = "Delete"
                )
            }
            Button(
                onClick = onReturn,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                backgroundColor = RaycastTheme.colorScheme.fillTertiary,
                contentColor = RaycastTheme.colorScheme.labelPrimary,
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 12.dp)
            ) {
                Icon(
                    imageVector = RaycastIcons.ArrowCornerDownLeft,
                    contentDescription = "Return"
                )
            }
        }

    }
}