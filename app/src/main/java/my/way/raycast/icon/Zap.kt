package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.Zap: ImageVector
    get() {
        if (_Zap != null) {
            return _Zap!!
        }
        _Zap = ImageVector.Builder(
            name = "Zap",
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
                moveTo(11.891f, 3.191f)
                curveTo(12.449f, 2.386f, 13.712f, 2.782f, 13.712f, 3.761f)
                lineTo(13.712f, 12.692f)
                curveTo(13.712f, 13.245f, 13.264f, 13.692f, 12.712f, 13.692f)
                horizontalLineTo(6.509f)
                curveTo(5.701f, 13.692f, 5.227f, 12.785f, 5.687f, 12.122f)
                lineTo(11.891f, 3.191f)
                close()
            }
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12.109f, 20.81f)
                curveTo(11.551f, 21.615f, 10.288f, 21.219f, 10.288f, 20.24f)
                lineTo(10.288f, 11.309f)
                curveTo(10.288f, 10.756f, 10.736f, 10.309f, 11.288f, 10.309f)
                horizontalLineTo(17.491f)
                curveTo(18.299f, 10.309f, 18.773f, 11.216f, 18.313f, 11.879f)
                lineTo(12.109f, 20.81f)
                close()
            }
        }.build()

        return _Zap!!
    }

@Suppress("ObjectPropertyName")
private var _Zap: ImageVector? = null
