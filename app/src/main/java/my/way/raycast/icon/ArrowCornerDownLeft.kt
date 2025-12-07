package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.ArrowCornerDownLeft: ImageVector
    get() {
        if (_ArrowCornerDownLeft != null) {
            return _ArrowCornerDownLeft!!
        }
        _ArrowCornerDownLeft = ImageVector.Builder(
            name = "ArrowCornerDownLeft",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(20.215f, 5.916f)
                verticalLineTo(8.681f)
                curveTo(20.215f, 10.514f, 18.729f, 12f, 16.896f, 12f)
                horizontalLineTo(5.745f)
                moveTo(10.723f, 5.915f)
                lineTo(4.639f, 12f)
                lineTo(10.723f, 18.084f)
            }
        }.build()

        return _ArrowCornerDownLeft!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowCornerDownLeft: ImageVector? = null
