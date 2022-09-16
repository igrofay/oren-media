package oksei.media.orenburg.presentation.ui.main.weather

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import oksei.media.orenburg.presentation.ui.widgets.SearchData
import oksei.media.orenburg.presentation.ui.widgets.no_have_data.NoHaveData
import oksei.media.orenburg.presentation.vm.settings.SettingsVM
import oksei.media.orenburg.presentation.vm.weather.WeatherEvent
import oksei.media.orenburg.presentation.vm.weather.WeatherNowSate
import oksei.media.orenburg.presentation.vm.weather.WeatherVM

@Composable
fun WeatherScreen() {
    val activity = LocalContext.current as ComponentActivity
    val weatherVM = hiltViewModel<WeatherVM>(activity)
    val settingsVM = hiltViewModel<SettingsVM>(activity)
    val state by remember {
        weatherVM.state
    }
    LaunchedEffect(true ){
        weatherVM.onEvent(WeatherEvent.UpdateWeatherNow)
    }
    when(state){
        WeatherNowSate.HaveData -> WeatherNowInfo(weatherVM.weatherNow!!, settingsVM.state.value.city)
        WeatherNowSate.LoadingData -> SearchData()
        WeatherNowSate.NoHaveData -> NoHaveData{ weatherVM.onEvent(WeatherEvent.UpdateWeatherNow) }
    }
}