package my.way.raycast.launcher.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import my.way.raycast.ui.theme.RaycastTheme
import org.koin.androidx.compose.koinViewModel


class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaycastTheme {
                val viewModel: LauncherViewModel = koinViewModel()
                val state by viewModel.state.collectAsStateWithLifecycle()
                LauncherScreen(
                    state = state,
                    onAction = viewModel::onAction,
                    searchQuery = viewModel.searchQuery
                )
            }
        }
    }
}