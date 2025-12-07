package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.IconArrowLeft: ImageVector
    get() {
        if (_IconArrowLeft != null) {
            return _IconArrowLeft!!
        }
        _IconArrowLeft = ImageVector.Builder(
            name = "IconArrowLeft",
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
                moveTo(8.557f, 7.443f)
                lineTo(4f, 12f)
                lineTo(8.557f, 16.557f)
                moveTo(5f, 12f)
                horizontalLineTo(20f)
            }
        }.build()

        return _IconArrowLeft!!
    }

@Suppress("ObjectPropertyName")
private var _IconArrowLeft: ImageVector? = null
