package oksei.media.orenburg.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavApp() {
    val nav = rememberNavController()
    NavHost(
        nav,
        RoutingApp.Starting.route
    ){
        composable(RoutingApp.Starting.route){
            NavStarting {
                nav.navigate(RoutingApp.Main.route){
                    popUpTo(RoutingApp.Starting.route) { inclusive = true }
                }
            }
        }
        composable(RoutingApp.Main.route){
            NavMain()
        }
    }
}