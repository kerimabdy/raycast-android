package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.ArrowShareRight: ImageVector
    get() {
        if (_ArrowShareRight != null) {
            return _ArrowShareRight!!
        }
        _ArrowShareRight = ImageVector.Builder(
            name = "ArrowShareRight",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(11.931f, 5.369f)
                curveTo(11.931f, 3.6f, 14.059f, 2.702f, 15.327f, 3.936f)
                lineTo(22.393f, 10.817f)
                curveTo(23.2f, 11.602f, 23.2f, 12.898f, 22.393f, 13.683f)
                lineTo(15.327f, 20.563f)
                curveTo(14.059f, 21.797f, 11.931f, 20.899f, 11.931f, 19.13f)
                verticalLineTo(16.757f)
                curveTo(8.513f, 16.812f, 6.606f, 17.15f, 5.419f, 17.69f)
                curveTo(4.223f, 18.235f, 3.686f, 19.014f, 3.013f, 20.327f)
                curveTo(2.455f, 21.416f, 0.922f, 20.91f, 0.934f, 19.812f)
                curveTo(0.976f, 15.681f, 1.633f, 12.565f, 3.613f, 10.525f)
                curveTo(5.443f, 8.638f, 8.202f, 7.875f, 11.931f, 7.764f)
                verticalLineTo(5.369f)
                close()
            }
        }.build()

        return _ArrowShareRight!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowShareRight: ImageVector? = null
