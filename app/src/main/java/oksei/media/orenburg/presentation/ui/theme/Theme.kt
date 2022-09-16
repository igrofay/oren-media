package oksei.media.orenburg.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import oksei.media.orenburg.presentation.ui.theme.getTypography

private val DarkColorPalette = darkColors(
    primary = PrimaryNight ,
    primaryVariant = PrimaryVariantNight,
    secondary = SecondaryNight,
    secondaryVariant= While900,
    background = Black900
)

private val LightColorPalette = lightColors(
    primary = PrimaryDay,
    primaryVariant = PrimaryVariantDay,
    secondary = SecondaryDay,
    secondaryVariant = PrimaryVariantDay,
    background = While900

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MediaOrenburgTheme(
    darkTheme: Boolean,
    scaleText: Float,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = getTypography(scaleText),
        shapes = Shapes,
        content = content
    )
}