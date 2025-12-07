package my.way.raycast.keyboard.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.composeunstyled.Button
import com.composeunstyled.Text
import my.way.raycast.ui.theme.InterFontFamily
import my.way.raycast.ui.theme.RaycastTheme

@Composable
fun GridItem(
    text: String,
    @DrawableRes image: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        borderColor = RaycastTheme.colorScheme.separatorOpaque,
        borderWidth = 1.dp,
        backgroundColor = RaycastTheme.colorScheme.fillQuaternary,
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.Companion
            .width(170.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier.size(24.dp).clip(RoundedCornerShape(8.dp))
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = text,
            style = RaycastTheme.typography.subheadline,
            fontFamily = InterFontFamily.SemiBold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}