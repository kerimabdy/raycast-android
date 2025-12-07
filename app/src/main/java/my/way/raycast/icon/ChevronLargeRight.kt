package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.ChevronLargeRight: ImageVector
    get() {
        if (_ChevronLargeRight != null) {
            return _ChevronLargeRight!!
        }
        _ChevronLargeRight = ImageVector.Builder(
            name = "ChevronLargeRight",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(10.484f, 3.806f)
                curveTo(10.967f, 3.538f, 11.576f, 3.712f, 11.844f, 4.194f)
                lineTo(15.065f, 10.058f)
                curveTo(15.736f, 11.266f, 15.736f, 12.735f, 15.065f, 13.943f)
                lineTo(11.844f, 19.806f)
                curveTo(11.576f, 20.289f, 10.967f, 20.463f, 10.484f, 20.194f)
                curveTo(10.002f, 19.926f, 9.828f, 19.317f, 10.096f, 18.834f)
                lineTo(13.317f, 12.972f)
                curveTo(13.652f, 12.367f, 13.652f, 11.633f, 13.317f, 11.029f)
                lineTo(10.096f, 5.166f)
                curveTo(9.828f, 4.683f, 10.002f, 4.074f, 10.484f, 3.806f)
                close()
            }
        }.build()

        return _ChevronLargeRight!!
    }

@Suppress("ObjectPropertyName")
private var _ChevronLargeRight: ImageVector? = null
