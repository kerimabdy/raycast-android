package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.CircleCheck: ImageVector
    get() {
        if (_CircleCheck != null) {
            return _CircleCheck!!
        }
        _CircleCheck = ImageVector.Builder(
            name = "CircleCheck",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(12f, 2f)
                curveTo(6.477f, 2f, 2f, 6.477f, 2f, 12f)
                curveTo(2f, 17.523f, 6.477f, 22f, 12f, 22f)
                curveTo(17.523f, 22f, 22f, 17.523f, 22f, 12f)
                curveTo(22f, 6.477f, 17.523f, 2f, 12f, 2f)
                close()
                moveTo(15.774f, 10.133f)
                curveTo(16.124f, 9.706f, 16.061f, 9.076f, 15.633f, 8.726f)
                curveTo(15.206f, 8.376f, 14.576f, 8.439f, 14.226f, 8.867f)
                lineTo(10.426f, 13.512f)
                lineTo(9.207f, 12.293f)
                curveTo(8.817f, 11.902f, 8.183f, 11.902f, 7.793f, 12.293f)
                curveTo(7.402f, 12.683f, 7.402f, 13.317f, 7.793f, 13.707f)
                lineTo(9.793f, 15.707f)
                curveTo(9.993f, 15.907f, 10.268f, 16.013f, 10.55f, 15.999f)
                curveTo(10.832f, 15.985f, 11.095f, 15.852f, 11.274f, 15.633f)
                lineTo(15.774f, 10.133f)
                close()
            }
        }.build()

        return _CircleCheck!!
    }

@Suppress("ObjectPropertyName")
private var _CircleCheck: ImageVector? = null
