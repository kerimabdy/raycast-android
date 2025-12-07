package my.way.raycast.keyboard.presentation.component

import androidx.compose.ui.graphics.vector.ImageVector
import my.way.raycast.icon.CodeLines
import my.way.raycast.icon.RaycastIcons
import my.way.raycast.icon.SparklesTwo
import my.way.raycast.icon.Voice1
import my.way.raycast.icon.Zap

sealed class CommandTab(val key: String, val icon: ImageVector) {
    object AI : CommandTab("AI", RaycastIcons.SparklesTwo)
    object Voice : CommandTab("Voice", RaycastIcons.Voice1)
    object QuickLink : CommandTab("QuickLink", RaycastIcons.Zap)
    object Snippet : CommandTab("Snippet", RaycastIcons.CodeLines)
}

val commandTabKeyList = listOf(
    CommandTab.AI,
    CommandTab.Voice,
    CommandTab.QuickLink,
    CommandTab.Snippet
)