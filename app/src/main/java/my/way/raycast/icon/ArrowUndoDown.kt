package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.ArrowRetry: ImageVector
    get() {
        if (_ArrowRetry != null) {
            return _ArrowRetry!!
        }
        _ArrowRetry = ImageVector.Builder(
            name = "ArrowUndoDown",
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
                moveTo(21.544f, 14.602f)
                lineTo(19.362f, 16.784f)
                curveTo(18.484f, 17.662f, 17.061f, 17.662f, 16.183f, 16.784f)
                lineTo(14.001f, 14.602f)
                moveTo(17.772f, 16.126f)
                lineTo(17.772f, 13.3f)
                curveTo(17.772f, 9.576f, 14.754f, 6.557f, 11.03f, 6.557f)
                curveTo(7.306f, 6.557f, 4.287f, 9.576f, 4.287f, 13.3f)
                lineTo(4.287f, 16.784f)
            }
        }.build()

        return _ArrowRetry!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowRetry: ImageVector? = null
