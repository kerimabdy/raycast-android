package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.Clipboard: ImageVector
    get() {
        if (_Clipboard != null) {
            return _Clipboard!!
        }
        _Clipboard = ImageVector.Builder(
            name = "Clipboard",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(15f, 5f)
                horizontalLineTo(16f)
                curveTo(17.657f, 5f, 19f, 6.343f, 19f, 8f)
                verticalLineTo(18f)
                curveTo(19f, 19.657f, 17.657f, 21f, 16f, 21f)
                horizontalLineTo(8f)
                curveTo(6.343f, 21f, 5f, 19.657f, 5f, 18f)
                verticalLineTo(8f)
                curveTo(5f, 6.343f, 6.343f, 5f, 8f, 5f)
                horizontalLineTo(9f)
                moveTo(15f, 7f)
                verticalLineTo(6f)
                curveTo(15f, 4.343f, 13.657f, 3f, 12f, 3f)
                curveTo(10.343f, 3f, 9f, 4.343f, 9f, 6f)
                verticalLineTo(7f)
                horizontalLineTo(15f)
                close()
            }
        }.build()

        return _Clipboard!!
    }

@Suppress("ObjectPropertyName")
private var _Clipboard: ImageVector? = null
