package oksei.media.orenburg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import oksei.media.orenburg.presentation.navigation.NavMain
import oksei.media.orenburg.presentation.vm.settings.SettingsVM
import oksei.media.orenburg.ui.theme.MediaOrenburgTheme
import dagger.hilt.android.AndroidEntryPoint
import oksei.media.orenburg.presentation.navigation.NavApp
import oksei.media.orenburg.presentation.ui.starting.launch.LaunchScreen
import oksei.media.orenburg.presentation.vm.news.NewsVM
import oksei.media.orenburg.presentation.vm.weather.WeatherVM

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            hiltViewModel<NewsVM>(this)
            val settingsVM: SettingsVM = hiltViewModel(this)
            val state by remember {
                settingsVM.state
            }
            MediaOrenburgTheme(
                state.isDarkTheme ?: isSystemInDarkTheme(),
                state.scaleText,

            ) {
                NavApp()
            }
        }
    }
}