package oksei.media.orenburg.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import oksei.media.orenburg.presentation.vm.settings.SettingsEvent

fun getTypography(scaleText: Float): Typography{
    return Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp * scaleText,
        ),
        h3 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 52.sp * scaleText,
            letterSpacing = 0.sp
        ),
        h4 =  TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.SemiBold,
            fontSize = 34.sp * scaleText,
        ),
        h5 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp * scaleText,
            letterSpacing = 0.sp
        ),
        subtitle2 = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp*scaleText,
            letterSpacing = 0.1.sp
        ),
        subtitle1 =TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp * scaleText,
            letterSpacing = 0.15.sp
        ),
    )
}