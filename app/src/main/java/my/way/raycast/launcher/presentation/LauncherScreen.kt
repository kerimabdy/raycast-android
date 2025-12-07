package my.way.raycast.launcher.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import my.way.raycast.launcher.presentation.component.BackgroundWithLogo
import my.way.raycast.launcher.presentation.component.SearchBar
import my.way.raycast.launcher.presentation.component.SearchResultList
import my.way.raycast.launcher.presentation.util.Extension.getContactsAsSearchItem
import my.way.raycast.launcher.presentation.util.Extension.getLauncherAppsAsSearchItem

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LauncherScreen(
    modifier: Modifier = Modifier,
    state: LauncherUiState,
    searchQuery: TextFieldState,
    onAction: (LauncherAction) -> Unit,
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        onAction(LauncherAction.OnAppsLoaded(context.getLauncherAppsAsSearchItem()))
        onAction(LauncherAction.OnContactsLoaded(context.getContactsAsSearchItem()))
    }

    Column(
        modifier
            .background(Color.Black.copy(alpha = 0.85f))
            .fillMaxSize()
            .imePadding()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            when {
                state.searchResults.isNotEmpty() -> {
                    SearchResultList(state.searchResults)
                }

                else -> {
                    BackgroundWithLogo()
                }
            }
        }

        SearchBar(
            state = searchQuery,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        )
    }
}