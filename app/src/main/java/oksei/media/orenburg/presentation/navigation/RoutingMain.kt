package oksei.media.orenburg.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import oksei.media.orenburg.R

sealed class RoutingMain(val route: String, @StringRes val strRes: Int, @DrawableRes val iconRes: Int) {
    object News : RoutingMain("NewsRoute", R.string.news, R.drawable.ic_newspaper)
    object Radio : RoutingMain("RadioRoute", R.string.radio, R.drawable.ic_radio)
    object Weather : RoutingMain("WeatherRoute", R.string.weather, R.drawable.ic_sunny)
    object Settings : RoutingMain("SettingsRoute", R.string.settings, R.drawable.ic_settings)
}

val listRoutingMain = listOf(
    RoutingMain.News,
    RoutingMain.Radio,
    RoutingMain.Weather,
    RoutingMain.Settings
)