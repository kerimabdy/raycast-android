package my.way.raycast.demo_setup

import android.Manifest
import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.composeunstyled.Button
import com.composeunstyled.Icon
import com.composeunstyled.Text
import my.way.raycast.R
import my.way.raycast.icon.CircleCheck
import my.way.raycast.icon.RaycastIcons
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme


private fun isContactPermissionGranted(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.READ_CONTACTS
    ) == android.content.pm.PackageManager.PERMISSION_GRANTED
}

fun isKeyboardEnable(context: Context): Boolean {
    val packageName = context.packageName
    val enabledMethods =
        Settings.Secure.getString(context.contentResolver, Settings.Secure.ENABLED_INPUT_METHODS)
    return enabledMethods?.contains("$packageName/.keyboard.presentation.MyKeyboardService") == true
}

fun isAssistantDefault(context: Context): Boolean {
    val assistantComponent = Settings.Secure.getString(context.contentResolver, "assistant")
    return assistantComponent?.contains(context.packageName) == true
}

@Composable
fun DemoSetupScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var contactsPermissionIsGranted by remember {
        mutableStateOf(
            isContactPermissionGranted(context)
        )
    }
    var isAssistantDefault by remember {
        mutableStateOf(
            isAssistantDefault(context)
        )
    }
    var isKeyboardEnable by remember {
        mutableStateOf(
            isKeyboardEnable(context)
        )
    }


    val contactsPermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            contactsPermissionIsGranted = isGranted
        }
    )

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                contactsPermissionIsGranted = isContactPermissionGranted(context)
                isAssistantDefault = isAssistantDefault(context)
                isKeyboardEnable = isKeyboardEnable(context)
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(RaycastTheme.colorScheme.primaryBackground),
    ) {
        Header()
        Column(
            modifier = Modifier
                .background(RaycastTheme.colorScheme.gray5)
                .padding(horizontal = 24.dp)
                .padding(top = 24.dp, bottom = 40.dp)
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            SetupItem(
                title = "Set Raycast as default assistant app",
                description = "To call Raycast launcher with a power button",
                actionText = "Set",
                onActionClick = {
                    val intent = Intent(Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS)
                    intent.putExtra(
                        Settings.EXTRA_APP_PACKAGE,
                        context.packageName
                    ) // Optional: might focus on your app's entry
                    context.startActivity(intent)
                },
                isSetup = isAssistantDefault
            )
            HorizontalDivider(
                color = RaycastTheme.colorScheme.separatorNonOpaque,
                thickness = 0.75.dp
            )
            SetupItem(
                title = "Enable Raycast keyboard",
                description = "To get access to quicklinks, snippets and AI from a keyboard",
                actionText = "Enable",
                onActionClick = {
                    val intent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)
                    context.startActivity(intent)
                },
                isSetup = isKeyboardEnable
            )
            HorizontalDivider(
                color = RaycastTheme.colorScheme.separatorNonOpaque,
                thickness = 0.75.dp
            )
            SetupItem(
                title = "Give access to contacts (optional)",
                description = "Makes it possible to search for contacts in launcher",
                actionText = "Give access",
                onActionClick = {
                    contactsPermissionResultLauncher.launch(Manifest.permission.READ_CONTACTS)
                },
                isSetup = contactsPermissionIsGranted
            )
        }
    }
}

@Composable
private fun SetupItem(
    title: String,
    description: String,
    actionText: String,
    onActionClick: () -> Unit,
    isSetup: Boolean = false,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                text = title,
                style = RaycastTheme.typography.subheadline,
                color = RaycastTheme.colorScheme.labelPrimary
            )
            Text(
                text = description,
                style = RaycastTheme.typography.footnote,
                color = RaycastTheme.colorScheme.labelSecondary
            )
        }

        if (isSetup) {
            Icon(
                imageVector = RaycastIcons.CircleCheck,
                contentDescription = "Check",
                tint = RaycastTheme.colorScheme.labelSecondary
            )
        } else {
            Button(
                onClick = onActionClick,
                contentColor = RaycastTheme.colorScheme.brandColorRed
            ) {
                Text(
                    text = actionText,
                    style = RaycastTheme.typography.subheadline,
                )
            }
        }
    }
}

@Composable
private fun ColumnScope.Header() {
    Box(
        modifier = Modifier
            .weight(1f)
            .padding(24.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(72.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.raycast_logo),
                modifier = Modifier.size(48.dp),
                contentDescription = "Raycast Logo"
            )
            Text(
                text = buildAnnotatedString {
                    append("Raycast")
                    withStyle(
                        SpanStyle(
                            color = RaycastTheme.colorScheme.labelSecondary
                        )
                    ) {
                        append("\nfor Android")
                    }
                },
                style = RaycastTheme.typography.title1,
                fontFamily = InterFontFamily.Normal,
                color = RaycastTheme.colorScheme.labelPrimary
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun DemoSetupScreenPreview() {
    RaycastTheme {
        DemoSetupScreen()
    }
}

