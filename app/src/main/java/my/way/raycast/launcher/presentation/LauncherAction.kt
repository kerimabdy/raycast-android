package my.way.raycast.launcher.presentation

sealed interface LauncherAction {
    data class OnAppsLoaded(val apps: List<SearchItem.App>) : LauncherAction
    data class OnContactsLoaded(val contacts: List<SearchItem.Contacts>) : LauncherAction
}