package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.CrossSmall: ImageVector
    get() {
        if (_CrossSmall != null) {
            return _CrossSmall!!
        }
        _CrossSmall = ImageVector.Builder(
            name = "CrossSmall",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(8f, 8f)
                lineTo(16f, 16f)
                moveTo(16f, 8f)
                lineTo(8f, 16f)
            }
        }.build()

        return _CrossSmall!!
    }

@Suppress("ObjectPropertyName")
private var _CrossSmall: ImageVector? = null
