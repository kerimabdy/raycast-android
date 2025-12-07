package my.way.raycast.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RaycastIcons.Voice1: ImageVector
    get() {
        if (_Voice1 != null) {
            return _Voice1!!
        }
        _Voice1 = ImageVector.Builder(
            name = "Voice1",
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
                moveTo(8f, 4f)
                verticalLineTo(20f)
                moveTo(4f, 10f)
                verticalLineTo(14f)
                moveTo(12f, 8f)
                verticalLineTo(16f)
                moveTo(16f, 6f)
                verticalLineTo(18f)
                moveTo(20f, 10f)
                verticalLineTo(14f)
            }
        }.build()

        return _Voice1!!
    }

@Suppress("ObjectPropertyName")
private var _Voice1: ImageVector? = null
