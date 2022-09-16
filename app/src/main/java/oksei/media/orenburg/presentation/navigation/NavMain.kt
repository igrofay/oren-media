package oksei.media.orenburg.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import oksei.media.orenburg.presentation.ui.main.bottom_bar.MainBottomBar
import oksei.media.orenburg.presentation.ui.main.news.NewsScreen
import oksei.media.orenburg.presentation.ui.main.radio.RadioScreen
import oksei.media.orenburg.presentation.ui.main.settings.SettingsScreen
import oksei.media.orenburg.presentation.ui.main.weather.WeatherScreen

@Composable
fun NavMain() {
    val nav = rememberNavController()
    Scaffold(
        bottomBar = {
            MainBottomBar(
                navHost = nav,
                listRouting = listRoutingMain
            ){
                nav.navigate(it) {
                    popUpTo(nav.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    ) { innerPadding->
        NavHost(navController = nav, startDestination = RoutingMain.News.route, modifier = Modifier.padding(innerPadding)) {
            composable(RoutingMain.News.route) {
                NewsScreen()
            }
            composable(RoutingMain.Radio.route) {
                RadioScreen()
            }
            composable(RoutingMain.Weather.route) {
                WeatherScreen()
            }
            composable(RoutingMain.Settings.route) {
                SettingsScreen()
            }
        }
    }
}