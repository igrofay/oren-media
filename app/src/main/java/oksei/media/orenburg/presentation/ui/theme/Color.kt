package oksei.media.orenburg.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val PrimaryVariantDay = Color(0xFF0042ED)
val PrimaryVariantNight = Color(0xFF4075FF)

val PrimaryDay = Color(0xFF2F9AFF)
val PrimaryNight = Color(0xFF40A2FF)

val SecondaryDay = Color(0xFFFFB608)
val SecondaryNight = Color(0xFFFFCA00)

val While900 = Color(0xFFF4F4F5)
val Black900 = Color(0xFF272F3D)

val Colors.ColorText: Color
    get() = if (isLight) Black900 else While900