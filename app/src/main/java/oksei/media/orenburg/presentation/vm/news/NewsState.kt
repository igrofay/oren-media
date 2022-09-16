package oksei.media.orenburg.presentation.vm.news

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import oksei.media.orenburg.domain.model.NewsEvent
import oksei.media.orenburg.domain.types.DateType
import oksei.media.orenburg.domain.types.NewsType
import oksei.media.orenburg.domain.types.SortType

data class NewsState(
    val news: SnapshotStateList<NewsEvent> = mutableStateListOf(),
    val type: NewsType = NewsType.All,
    val date: DateType = DateType.AllTime,
    val sort: SortType = SortType.New,
    var stateList: MutableState<ListNewsEventsState> = mutableStateOf(ListNewsEventsState.LoadingData)
)