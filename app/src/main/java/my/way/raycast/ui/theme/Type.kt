package my.way.raycast.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.unit.sp
import my.way.raycast.R


val Inter = R.font.inter
val InterItalic = R.font.inter_italic


@OptIn(ExperimentalTextApi::class)
object InterFontFamily {
    // Regular variations
    val Normal = FontFamily(
        Font(
            Inter,
            variationSettings = FontVariation.Settings(
                FontVariation.width(100f),
                FontVariation.slant(0f),
                FontVariation.weight(400)  // Normal weight
            )
        )
    )

    val Medium = FontFamily(
        Font(
            Inter,
            variationSettings = FontVariation.Settings(
                FontVariation.width(100f),
                FontVariation.slant(0f),
                FontVariation.weight(500)  // Medium weight
            )
        )
    )

    val SemiBold = FontFamily(
        Font(
            Inter,
            variationSettings = FontVariation.Settings(
                FontVariation.width(100f),
                FontVariation.slant(0f),
                FontVariation.weight(600)  // SemiBold weight
            )
        )
    )

    val Bold = FontFamily(
        Font(
            Inter,
            variationSettings = FontVariation.Settings(
                FontVariation.width(100f),
                FontVariation.slant(0f),
                FontVariation.weight(700)  // Bold weight
            )
        )
    )

    // Italic variations
    val Italic = FontFamily(
        Font(
            InterItalic,
            variationSettings = FontVariation.Settings(
                FontVariation.width(100f),
                FontVariation.slant(10f),  // Italic slant
                FontVariation.weight(400)  // Normal weight
            )
        )
    )

    val MediumItalic = FontFamily(
        Font(
            InterItalic,
            variationSettings = FontVariation.Settings(
                FontVariation.width(100f),
                FontVariation.slant(10f),  // Italic slant
                FontVariation.weight(500)  // Medium weight
            )
        )
    )

    val SemiBoldItalic = FontFamily(
        Font(
            InterItalic,
            variationSettings = FontVariation.Settings(
                FontVariation.width(100f),
                FontVariation.slant(10f),  // Italic slant
                FontVariation.weight(600)  // SemiBold weight
            )
        )
    )

    val BoldItalic = FontFamily(
        Font(
            InterItalic,
            variationSettings = FontVariation.Settings(
                FontVariation.width(100f),
                FontVariation.slant(10f),  // Italic slant
                FontVariation.weight(700)  // Bold weight
            )
        )
    )
}

@Immutable
data class RaycastTypography(
    val largeTitle: TextStyle,
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val headline: TextStyle,
    val body: TextStyle,
    val callout: TextStyle,
    val subheadline: TextStyle,
    val footnote: TextStyle,
    val caption1: TextStyle,
    val caption2: TextStyle
)

val LocalRaycastTypography = staticCompositionLocalOf {
    RaycastTypography(
        largeTitle = TextStyle.Default,
        title1 = TextStyle.Default,
        title2 = TextStyle.Default,
        title3 = TextStyle.Default,
        headline = TextStyle.Default,
        body = TextStyle.Default,
        callout = TextStyle.Default,
        subheadline = TextStyle.Default,
        footnote = TextStyle.Default,
        caption1 = TextStyle.Default,
        caption2 = TextStyle.Default
    )
}

val raycastTypography = RaycastTypography(
    largeTitle = TextStyle(
        fontFamily = InterFontFamily.Bold,
        fontSize = 34.sp,
        lineHeight = 41.sp,
        letterSpacing = 0.37.sp
    ),
    title1 = TextStyle(
        fontFamily = InterFontFamily.Bold,
        fontSize = 28.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.36.sp
    ),
    title2 = TextStyle(
        fontFamily = InterFontFamily.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.35.sp
    ),
    title3 = TextStyle(
        fontFamily = InterFontFamily.Bold,
        fontSize = 20.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.38.sp
    ),
    headline = TextStyle(
        fontFamily = InterFontFamily.SemiBold,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.41).sp
    ),
    body = TextStyle(
        fontFamily = InterFontFamily.Normal,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.41).sp
    ),
    callout = TextStyle(
        fontFamily = InterFontFamily.Normal,
        fontSize = 16.sp,
        lineHeight = 21.sp,
        letterSpacing = (-0.32).sp
    ),
    subheadline = TextStyle(
        fontFamily = InterFontFamily.Normal,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.24).sp
    ),
    footnote = TextStyle(
        fontFamily = InterFontFamily.Normal,
        fontSize = 13.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.08).sp
    ),
    caption1 = TextStyle(
        fontFamily = InterFontFamily.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    caption2 = TextStyle(
        fontFamily = InterFontFamily.Normal,
        fontSize = 11.sp,
        lineHeight = 13.sp,
        letterSpacing = 0.06.sp
    )
)