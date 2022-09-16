package oksei.media.orenburg.presentation.ui.starting.launch

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import oksei.media.orenburg.R

@Composable
fun LaunchScreen() {
    val textApp = remember {
        mutableStateOf("")
    }
    val scaleIconApp = rememberSaveable {
        mutableStateOf(1f)
    }
    AnimateIconApp(
        scaleIconApp.component2()
    )
    AnimateInputText(
        stringResource(R.string.app_name),
        textApp.component2()
    )
    when(LocalConfiguration.current.orientation){
        Configuration.ORIENTATION_LANDSCAPE -> LaunchHorizontal(textApp.value.split(' ').joinToString('\n'.toString()), scaleIconApp.value)
        else -> LaunchVertical(textApp.value,scaleIconApp.value)
    }
}

