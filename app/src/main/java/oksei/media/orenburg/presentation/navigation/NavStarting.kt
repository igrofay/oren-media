package oksei.media.orenburg.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import oksei.media.orenburg.presentation.ui.starting.launch.LaunchScreen

@Composable
fun NavStarting(goToNext: ()->Unit){
    LaunchedEffect(goToNext){
        delay(3500)
        goToNext()
    }
    LaunchScreen()
}
