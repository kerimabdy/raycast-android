package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.CodeLines: ImageVector
    get() {
        if (_CodeLines != null) {
            return _CodeLines!!
        }
        _CodeLines = ImageVector.Builder(
            name = "CodeLines",
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
                moveTo(3f, 5f)
                horizontalLineTo(13f)
                moveTo(18f, 5f)
                horizontalLineTo(21f)
                moveTo(3f, 12f)
                horizontalLineTo(8f)
                moveTo(13f, 12f)
                horizontalLineTo(21f)
                moveTo(3f, 19f)
                horizontalLineTo(10f)
                moveTo(15f, 19f)
                horizontalLineTo(21f)
            }
        }.build()

        return _CodeLines!!
    }

@Suppress("ObjectPropertyName")
private var _CodeLines: ImageVector? = null
