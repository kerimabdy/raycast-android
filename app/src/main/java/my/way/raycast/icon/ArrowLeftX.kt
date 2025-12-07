package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.ArrowLeftX: ImageVector
    get() {
        if (_ArrowLeftX != null) {
            return _ArrowLeftX!!
        }
        _ArrowLeftX = ImageVector.Builder(
            name = "ArrowLeftX",
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
                moveTo(11.249f, 10f)
                lineTo(15.25f, 14.002f)
                moveTo(15.252f, 10f)
                lineTo(11.25f, 14.002f)
                moveTo(3.815f, 10.096f)
                lineTo(7.1f, 6.096f)
                curveTo(7.67f, 5.402f, 8.521f, 5f, 9.419f, 5f)
                horizontalLineTo(18f)
                curveTo(19.657f, 5f, 21f, 6.343f, 21f, 8f)
                verticalLineTo(16f)
                curveTo(21f, 17.657f, 19.657f, 19f, 18f, 19f)
                horizontalLineTo(9.419f)
                curveTo(8.521f, 19f, 7.67f, 18.598f, 7.1f, 17.904f)
                lineTo(3.815f, 13.904f)
                curveTo(2.906f, 12.797f, 2.906f, 11.203f, 3.815f, 10.096f)
                close()
            }
        }.build()

        return _ArrowLeftX!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowLeftX: ImageVector? = null
