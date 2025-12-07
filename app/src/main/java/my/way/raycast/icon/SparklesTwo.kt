package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.SparklesTwo: ImageVector
    get() {
        if (_SparklesTwo != null) {
            return _SparklesTwo!!
        }
        _SparklesTwo = ImageVector.Builder(
            name = "SparklesTwo",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(15.438f, 7.938f)
                curveTo(15.438f, 7.42f, 15.018f, 7f, 14.5f, 7f)
                curveTo(13.982f, 7f, 13.563f, 7.42f, 13.563f, 7.938f)
                curveTo(13.563f, 10.102f, 13.084f, 11.446f, 12.265f, 12.265f)
                curveTo(11.446f, 13.084f, 10.102f, 13.563f, 7.938f, 13.563f)
                curveTo(7.42f, 13.563f, 7f, 13.982f, 7f, 14.5f)
                curveTo(7f, 15.018f, 7.42f, 15.438f, 7.938f, 15.438f)
                curveTo(10.102f, 15.438f, 11.446f, 15.916f, 12.265f, 16.735f)
                curveTo(13.084f, 17.554f, 13.563f, 18.898f, 13.563f, 21.063f)
                curveTo(13.563f, 21.58f, 13.982f, 22f, 14.5f, 22f)
                curveTo(15.018f, 22f, 15.438f, 21.58f, 15.438f, 21.063f)
                curveTo(15.438f, 18.898f, 15.916f, 17.554f, 16.735f, 16.735f)
                curveTo(17.554f, 15.916f, 18.898f, 15.438f, 21.063f, 15.438f)
                curveTo(21.58f, 15.438f, 22f, 15.018f, 22f, 14.5f)
                curveTo(22f, 13.982f, 21.58f, 13.563f, 21.063f, 13.563f)
                curveTo(18.898f, 13.563f, 17.554f, 13.084f, 16.735f, 12.265f)
                curveTo(15.916f, 11.446f, 15.438f, 10.102f, 15.438f, 7.938f)
                close()
            }
            path(fill = SolidColor(Color.Black)) {
                moveTo(7.909f, 2.909f)
                curveTo(7.909f, 2.407f, 7.502f, 2f, 7f, 2f)
                curveTo(6.498f, 2f, 6.091f, 2.407f, 6.091f, 2.909f)
                curveTo(6.091f, 4.219f, 5.8f, 4.954f, 5.377f, 5.377f)
                curveTo(4.954f, 5.8f, 4.219f, 6.091f, 2.909f, 6.091f)
                curveTo(2.407f, 6.091f, 2f, 6.498f, 2f, 7f)
                curveTo(2f, 7.502f, 2.407f, 7.909f, 2.909f, 7.909f)
                curveTo(4.219f, 7.909f, 4.954f, 8.2f, 5.377f, 8.623f)
                curveTo(5.8f, 9.046f, 6.091f, 9.781f, 6.091f, 11.091f)
                curveTo(6.091f, 11.593f, 6.498f, 12f, 7f, 12f)
                curveTo(7.502f, 12f, 7.909f, 11.593f, 7.909f, 11.091f)
                curveTo(7.909f, 9.781f, 8.2f, 9.046f, 8.623f, 8.623f)
                curveTo(9.046f, 8.2f, 9.781f, 7.909f, 11.091f, 7.909f)
                curveTo(11.593f, 7.909f, 12f, 7.502f, 12f, 7f)
                curveTo(12f, 6.498f, 11.593f, 6.091f, 11.091f, 6.091f)
                curveTo(9.781f, 6.091f, 9.046f, 5.8f, 8.623f, 5.377f)
                curveTo(8.2f, 4.954f, 7.909f, 4.219f, 7.909f, 2.909f)
                close()
            }
        }.build()

        return _SparklesTwo!!
    }

@Suppress("ObjectPropertyName")
private var _SparklesTwo: ImageVector? = null
