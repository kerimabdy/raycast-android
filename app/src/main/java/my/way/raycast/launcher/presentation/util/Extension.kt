package my.way.raycast.launcher.presentation.util

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.util.Log
import androidx.core.net.toUri
import my.way.raycast.launcher.presentation.SearchItem

object Extension {
    fun Context.getLauncherAppsAsSearchItem(): List<SearchItem.App> {
        val pm = this.packageManager

        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory((Intent.CATEGORY_LAUNCHER))
        }

        val apps = pm.queryIntentActivities(intent, 0).map { app ->
            Log.d("Apps", "app: $app")
            SearchItem.App(
                name = app.loadLabel(pm).toString(),
                icon = app.loadIcon(pm),
                packageName = app.activityInfo.packageName,
            )
        }

        return apps
    }


    fun Context.getContactsAsSearchItem(): List<SearchItem.Contacts> {
        val contacts = mutableListOf<SearchItem.Contacts>()

        val cursor = this.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.PHOTO_URI
            ),
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )

        cursor?.use {
            val idIdx = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID)
            val nameIdx = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val phoneIdx = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            val photoIdx = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI)
            val lookupIdx = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY)


            while (it.moveToNext()) {
                val id = it.getLong(idIdx)
                val name = it.getString(nameIdx) ?: continue
                val phone = it.getString(phoneIdx) ?: continue
                val photoUri = it.getString(photoIdx)?.toUri()
                val lookup = it.getString(lookupIdx)
                val contactUri = ContactsContract.Contacts.getLookupUri(id, lookup)


                contacts.add(
                    SearchItem.Contacts(
                        id = id,
                        name = name,
                        phone = phone,
                        photoUri = photoUri,
                        lookupKey = lookup,
                        uri = contactUri
                    )
                )
            }
        }

        return contacts

    }
}