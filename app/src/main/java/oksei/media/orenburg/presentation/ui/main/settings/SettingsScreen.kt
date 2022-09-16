package oksei.media.orenburg.presentation.ui.main.settings

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import oksei.media.orenburg.presentation.vm.settings.SettingsEvent
import oksei.media.orenburg.presentation.vm.settings.SettingsVM
import oksei.media.orenburg.ui.theme.ColorText

@Composable
fun SettingsScreen(

) {
    val activity = LocalContext.current as ComponentActivity
    val settingsVM: SettingsVM = hiltViewModel(activity)
    val state by remember {
        settingsVM.state
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 30.dp, vertical = 30.dp),
    ){
        item {
            TurnImageInNews(state.imageInNews){
                settingsVM.onEvent(SettingsEvent.DisplayImagesInNews(it))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = MaterialTheme.colors.ColorText)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            SetThemeApp(state.isDarkTheme){
                settingsVM.onEvent(SettingsEvent.ChangeThemeApp(it))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = MaterialTheme.colors.ColorText)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            SetScaleText(
                state.scaleText
            ){
                settingsVM.onEvent(SettingsEvent.ChangeScaleText(it))
            }
        }
    }
}

