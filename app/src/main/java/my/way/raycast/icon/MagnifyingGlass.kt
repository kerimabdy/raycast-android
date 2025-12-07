package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.MagnifyingGlass2: ImageVector
    get() {
        if (_MagnifyingGlass2 != null) {
            return _MagnifyingGlass2!!
        }
        _MagnifyingGlass2 = ImageVector.Builder(
            name = "MagnifyingGlass2",
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
                moveTo(11f, 18f)
                curveTo(14.866f, 18f, 18f, 14.866f, 18f, 11f)
                curveTo(18f, 7.134f, 14.866f, 4f, 11f, 4f)
                curveTo(7.134f, 4f, 4f, 7.134f, 4f, 11f)
                curveTo(4f, 14.866f, 7.134f, 18f, 11f, 18f)
                close()
            }
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(20f, 20f)
                lineTo(16.05f, 16.05f)
            }
        }.build()

        return _MagnifyingGlass2!!
    }

@Suppress("ObjectPropertyName")
private var _MagnifyingGlass2: ImageVector? = null
