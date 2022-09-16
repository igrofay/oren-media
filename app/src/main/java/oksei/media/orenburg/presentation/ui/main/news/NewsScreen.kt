package oksei.media.orenburg.presentation.ui.main.news

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import oksei.media.orenburg.R
import oksei.media.orenburg.domain.types.DateType
import oksei.media.orenburg.domain.types.NewsType
import oksei.media.orenburg.domain.types.SortType
import oksei.media.orenburg.presentation.ui.widgets.SearchData
import oksei.media.orenburg.presentation.ui.widgets.no_have_data.NoHaveData
import oksei.media.orenburg.presentation.vm.news.ListNewsEventsState
import oksei.media.orenburg.presentation.vm.news.NewsInfoEvent
import oksei.media.orenburg.presentation.vm.news.NewsState
import oksei.media.orenburg.presentation.vm.news.NewsVM
import oksei.media.orenburg.presentation.vm.settings.SettingsVM
import oksei.media.orenburg.ui.theme.While900

@Composable
fun NewsScreen() {
    val activity = LocalContext.current as ComponentActivity
    val newsVM: NewsVM = hiltViewModel(activity)
    val settingsVM: SettingsVM = hiltViewModel(activity)
    val state = remember { newsVM.state }
    var changeNewsSettings by remember {
        mutableStateOf(false)
    }
    val openNews by remember {
        newsVM.openNews
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Text(
                    stringResource(R.string.always_fresh_news),
                    color = While900,
                    modifier = Modifier.fillMaxWidth(),
                    style = typography.subtitle2
                )
            },
            actions = {
                IconButton(
                    onClick = { changeNewsSettings = true }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_filter),
                        contentDescription = null,
                        tint = While900
                    )
                }
            },
            elevation = 12.dp,
            backgroundColor = colors.primary
        )

        when(state.value.stateList.value){
            ListNewsEventsState.HaveData -> NewsList(
                list = state.value.news,
                imagesInNews = settingsVM.state.value.imageInNews,
                openNewsEvent = { newsVM.onEvent(NewsInfoEvent.OpenNews(it)) }
            )
            ListNewsEventsState.LoadingData -> SearchData()
            ListNewsEventsState.NoHaveData ->{
                val resetData = state.value.run {
                    if (type == NewsType.All && date == DateType.AllTime && sort == SortType.New){ null }else{ { newsVM.onEvent(NewsInfoEvent.ResetNews) } }
                }
                NoHaveData(resetData)
            }
        }
    }
    if (changeNewsSettings){
        ChangeNewsSettings(
            state = state.value,
            reset = { newsVM.onEvent(NewsInfoEvent.ResetNews) },
            apply = { type, date, sort -> newsVM.onEvent(NewsInfoEvent.ToggleNews(type,date,sort)) },
            close = { changeNewsSettings = false}
        )
    }
    DetailedNewsList(openNews){
        newsVM.onEvent(NewsInfoEvent.CloseDetailedNews)
    }
}

