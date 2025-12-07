package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.Call: ImageVector
    get() {
        if (_Call != null) {
            return _Call!!
        }
        _Call = ImageVector.Builder(
            name = "Call",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(6.754f, 3f)
                curveTo(4.738f, 3f, 2.866f, 4.684f, 3.25f, 6.91f)
                curveTo(4.468f, 13.968f, 10.034f, 19.534f, 17.091f, 20.752f)
                curveTo(19.317f, 21.136f, 21.001f, 19.263f, 21.001f, 17.248f)
                curveTo(21.001f, 15.591f, 19.914f, 14.13f, 18.327f, 13.654f)
                lineTo(17.333f, 13.355f)
                curveTo(16.337f, 13.057f, 15.258f, 13.329f, 14.524f, 14.064f)
                curveTo(14.257f, 14.33f, 13.914f, 14.347f, 13.697f, 14.212f)
                curveTo(12.111f, 13.231f, 10.77f, 11.891f, 9.789f, 10.305f)
                curveTo(9.654f, 10.087f, 9.671f, 9.744f, 9.938f, 9.478f)
                curveTo(10.673f, 8.743f, 10.945f, 7.664f, 10.646f, 6.669f)
                lineTo(10.348f, 5.674f)
                curveTo(9.871f, 4.087f, 8.411f, 3f, 6.754f, 3f)
                close()
            }
        }.build()

        return _Call!!
    }

@Suppress("ObjectPropertyName")
private var _Call: ImageVector? = null
