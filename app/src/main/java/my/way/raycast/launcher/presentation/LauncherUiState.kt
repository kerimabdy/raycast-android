package my.way.raycast.launcher.presentation

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Stable
data class LauncherUiState(
    val searchItems: List<SearchItem> = emptyList(),
    val searchResults: List<SearchItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

@Immutable
sealed class SearchItem {
    abstract val name: String

    data class App(
        override val name: String,
        val icon: Drawable,
        val packageName: String,
    ) : SearchItem() {
        fun openApp(context: Context) {
            val intent = context.packageManager.getLaunchIntentForPackage(packageName)
            context.startActivity(intent)
        }
    }

    data class Command(
        override val name: String,
        @param:DrawableRes val iconUri: Int,
    ) : SearchItem()

    data class Contacts(
        val id: Long,
        val lookupKey: String,
        override val name: String,
        val phone: String,
        val photoUri: Uri?,
        val uri: Uri,
    ) : SearchItem() {
        fun openContact(context: Context) {
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        }

        fun callContact(context: Context) {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phone")
            }
            context.startActivity(intent)
        }

        fun sendSms(context: Context) {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("sms:$phone")
            }
            context.startActivity(intent)
        }

        fun shareContact(context: Context) {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "$name\n$phone")
            }
            context.startActivity(Intent.createChooser(intent, "Share contact"))
        }
    }
}



