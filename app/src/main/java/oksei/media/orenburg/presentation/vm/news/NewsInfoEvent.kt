package oksei.media.orenburg.presentation.vm.news

import oksei.media.orenburg.domain.types.DateType
import oksei.media.orenburg.domain.types.NewsType
import oksei.media.orenburg.domain.types.SortType

sealed class NewsInfoEvent{
    data class OpenNews(val id: String): NewsInfoEvent()
    object ResetNews : NewsInfoEvent()
    data class ToggleNews(val filter: NewsType, val date: DateType, val sort: SortType): NewsInfoEvent()
    object CloseDetailedNews: NewsInfoEvent()
}
