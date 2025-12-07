package my.way.raycast.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


internal object BrandColorTokens {
    val RaycastRed = Color(0xFFFF6161)
}



internal object LightColorTokens {
    // Background Colors
    val PrimaryBackground = Color(0xFFFFFFFF)    // White
    val SecondaryBackground = Color(0xFFF2F2F7)  // F2F2F7
    val TertiaryBackground = Color(0xFFFFFFFF)   // White

    // Label Colors
    val LabelPrimary = Color(0xFF000000)      // 000000 (100%)
    val LabelSecondary = Color(0x993C3C43)    // 3C3C43 (60%)
    val LabelTertiary = Color(0x4D3C3C43)     // 3C3C43 (30%)
    val LabelQuaternary = Color(0x2E3C3C43)   // 3C3C43 (18%)

    // Fill Colors
    val FillPrimary = Color(0x33787880)    // 20% opacity
    val FillSecondary = Color(0x29787880)  // 16% opacity
    val FillTertiary = Color(0x1F787880)   // 12% opacity
    val FillQuaternary = Color(0x14787880) // 8% opacity

    // System Colors
    val Blue = Color(0xFF007AFF)
    val Green = Color(0xFF34C759)
    val Indigo = Color(0xFF5856D6)
    val Orange = Color(0xFFFF9500)
    val Pink = Color(0xFFFF2D55)
    val Purple = Color(0xFFAF52DE)
    val Red = Color(0xFFFF3B30)
    val Teal = Color(0xFF30B0C7)
    val Yellow = Color(0xFFFFCC00)
    val Brown = Color(0xFFA2845E)

    // Overlay Colors
    val OverlayDefault = Color(0x33000000)    // 000000 (20%)
    val OverlayActivityViewController = Color(0x1F000000)    // 000000 (12%)

    // Separator Colors
    val SeparatorOpaque = Color(0xFFC6C6C8)    // C6C6C8 (100%)
    val SeparatorNonOpaque = Color(0x57545456)  // 545456 (34%)

    // Gray Colors
    val Gray = Color(0xFF8E8E93)
    val Gray2 = Color(0xFFAEAEB2)
    val Gray3 = Color(0xFFC7C7CC)
    val Gray4 = Color(0xFFD1D1D6)
    val Gray5 = Color(0xFFE5E5EA)
    val Gray6 = Color(0xFFF2F2F7)
}

internal object DarkColorTokens {
    // Background Colors
    val PrimaryBackground = Color(0xFF000000)     // Black
    val SecondaryBackground = Color(0xFF1C1C1E)   // 1C1C1E
    val TertiaryBackground = Color(0xFF2C2C2E)    // 2C2C2E

    // Label Colors
    val LabelPrimary = Color(0xFFFFFFFF)       // FFFFFF (100%)
    val LabelSecondary = Color(0x99EBEBF5)     // EBEBF5 (60%)
    val LabelTertiary = Color(0x4DEBEBF5)      // EBEBF5 (30%)
    val LabelQuaternary = Color(0x29EBEBF5)    // EBEBF5 (16%)

    // Fill Colors
    val FillPrimary = Color(0x5C787880)     // 36% opacity
    val FillSecondary = Color(0x52787880)   // 32% opacity
    val FillTertiary = Color(0x3D787880)    // 24% opacity
    val FillQuaternary = Color(0x2E787880)  // 18% opacity

    // System Colors
    val Blue = Color(0xFF0A84FF)
    val Green = Color(0xFF30D158)
    val Indigo = Color(0xFF5E5CE6)
    val Orange = Color(0xFFFF9F0A)
    val Pink = Color(0xFFFF375F)
    val Purple = Color(0xFFBF5AF2)
    val Red = Color(0xFFFF453A)
    val Teal = Color(0xFF40CBE0)
    val Yellow = Color(0xFFFFD60A)
    val Brown = Color(0xFFAC8E68)

    // Overlay Colors
    val OverlayDefault = Color(0x7D000000)     // 000000 (49%)
    val OverlayActivityViewController = Color(0x4A000000)     // 000000 (29%)

    // Separator Colors
    val SeparatorOpaque = Color(0xFF38383A)     // 38383A (100%)
    val SeparatorNonOpaque = Color(0x99545456)   // 545456 (60%)

    // Gray Colors
    val Gray = Color(0xFF8E8E93)
    val Gray2 = Color(0xFF636366)
    val Gray3 = Color(0xFF48484A)
    val Gray4 = Color(0xFF3A3A3C)
    val Gray5 = Color(0xFF2C2C2E)
    val Gray6 = Color(0xFF1C1C1E)
}


@Immutable
data class RaycastColors(
    val brandColorRed: Color,
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val tertiaryBackground: Color,
    val labelPrimary: Color,
    val labelSecondary: Color,
    val labelTertiary: Color,
    val labelQuaternary: Color,
    val fillPrimary: Color,
    val fillSecondary: Color,
    val fillTertiary: Color,
    val fillQuaternary: Color,
    val blue: Color,
    val green: Color,
    val indigo: Color,
    val orange: Color,
    val pink: Color,
    val purple: Color,
    val red: Color,
    val teal: Color,
    val yellow: Color,
    val brown: Color,
    val overlayDefault: Color,
    val overlayActivityViewController: Color,
    val separatorOpaque: Color,
    val separatorNonOpaque: Color,
    val primary: Color,
    val gray: Color,
    val gray2: Color,
    val gray3: Color,
    val gray4: Color,
    val gray5: Color,
    val gray6: Color
)

internal val LocalRaycastColors = staticCompositionLocalOf {
    RaycastColors(
        brandColorRed = Color.Unspecified,
        primaryBackground = Color.Unspecified,
        secondaryBackground = Color.Unspecified,
        tertiaryBackground = Color.Unspecified,
        labelPrimary = Color.Unspecified,
        labelSecondary = Color.Unspecified,
        labelTertiary = Color.Unspecified,
        labelQuaternary = Color.Unspecified,
        fillPrimary = Color.Unspecified,
        fillSecondary = Color.Unspecified,
        fillTertiary = Color.Unspecified,
        fillQuaternary = Color.Unspecified,
        blue = Color.Unspecified,
        green = Color.Unspecified,
        indigo = Color.Unspecified,
        orange = Color.Unspecified,
        pink = Color.Unspecified,
        purple = Color.Unspecified,
        red = Color.Unspecified,
        teal = Color.Unspecified,
        yellow = Color.Unspecified,
        brown = Color.Unspecified,
        overlayDefault = Color.Unspecified,
        overlayActivityViewController = Color.Unspecified,
        separatorOpaque = Color.Unspecified,
        separatorNonOpaque = Color.Unspecified,
        primary = Color.Unspecified,
        gray = Color.Unspecified,
        gray2 = Color.Unspecified,
        gray3 = Color.Unspecified,
        gray4 = Color.Unspecified,
        gray5 = Color.Unspecified,
        gray6 = Color.Unspecified
    )
}

internal val DarkColorScheme = RaycastColors(
    brandColorRed = BrandColorTokens.RaycastRed,
    primaryBackground = DarkColorTokens.PrimaryBackground,
    secondaryBackground = DarkColorTokens.SecondaryBackground,
    tertiaryBackground = DarkColorTokens.TertiaryBackground,
    labelPrimary = DarkColorTokens.LabelPrimary,
    labelSecondary = DarkColorTokens.LabelSecondary,
    labelTertiary = DarkColorTokens.LabelTertiary,
    labelQuaternary = DarkColorTokens.LabelQuaternary,
    fillPrimary = DarkColorTokens.FillPrimary,
    fillSecondary = DarkColorTokens.FillSecondary,
    fillTertiary = DarkColorTokens.FillTertiary,
    fillQuaternary = DarkColorTokens.FillQuaternary,
    blue = DarkColorTokens.Blue,
    green = DarkColorTokens.Green,
    indigo = DarkColorTokens.Indigo,
    orange = DarkColorTokens.Orange,
    pink = DarkColorTokens.Pink,
    purple = DarkColorTokens.Purple,
    red = DarkColorTokens.Red,
    teal = DarkColorTokens.Teal,
    yellow = DarkColorTokens.Yellow,
    brown = DarkColorTokens.Brown,
    overlayDefault = DarkColorTokens.OverlayDefault,
    overlayActivityViewController = DarkColorTokens.OverlayActivityViewController,
    separatorOpaque = DarkColorTokens.SeparatorOpaque,
    separatorNonOpaque = DarkColorTokens.SeparatorNonOpaque,
    primary = Color.White,
    gray = DarkColorTokens.Gray,
    gray2 = DarkColorTokens.Gray2,
    gray3 = DarkColorTokens.Gray3,
    gray4 = DarkColorTokens.Gray4,
    gray5 = DarkColorTokens.Gray5,
    gray6 = DarkColorTokens.Gray6
)

internal val LightColorScheme = RaycastColors(
    brandColorRed = BrandColorTokens.RaycastRed,
    primaryBackground = LightColorTokens.PrimaryBackground,
    secondaryBackground = LightColorTokens.SecondaryBackground,
    tertiaryBackground = LightColorTokens.TertiaryBackground,
    labelPrimary = LightColorTokens.LabelPrimary,
    labelSecondary = LightColorTokens.LabelSecondary,
    labelTertiary = LightColorTokens.LabelTertiary,
    labelQuaternary = LightColorTokens.LabelQuaternary,
    fillPrimary = LightColorTokens.FillPrimary,
    fillSecondary = LightColorTokens.FillSecondary,
    fillTertiary = LightColorTokens.FillTertiary,
    fillQuaternary = LightColorTokens.FillQuaternary,
    blue = LightColorTokens.Blue,
    green = LightColorTokens.Green,
    indigo = LightColorTokens.Indigo,
    orange = LightColorTokens.Orange,
    pink = LightColorTokens.Pink,
    purple = LightColorTokens.Purple,
    red = LightColorTokens.Red,
    teal = LightColorTokens.Teal,
    yellow = LightColorTokens.Yellow,
    brown = LightColorTokens.Brown,
    overlayDefault = LightColorTokens.OverlayDefault,
    overlayActivityViewController = LightColorTokens.OverlayActivityViewController,
    separatorOpaque = LightColorTokens.SeparatorOpaque,
    separatorNonOpaque = LightColorTokens.SeparatorNonOpaque,
    primary = Color.Black,
    gray = LightColorTokens.Gray,
    gray2 = LightColorTokens.Gray2,
    gray3 = LightColorTokens.Gray3,
    gray4 = LightColorTokens.Gray4,
    gray5 = LightColorTokens.Gray5,
    gray6 = LightColorTokens.Gray6
)
