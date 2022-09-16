package oksei.media.orenburg.domain.use_case.news

import android.util.Log
import io.ktor.client.network.sockets.*
import kotlinx.coroutines.delay
import oksei.media.orenburg.domain.model.NewsEvent
import oksei.media.orenburg.domain.repository.NewsRepository
import oksei.media.orenburg.domain.types.DateType
import oksei.media.orenburg.domain.types.NewsType
import oksei.media.orenburg.domain.types.SortType

class GetListNewsEvent(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(
        filter: NewsType, date: DateType, sort: SortType
    ): List<NewsEvent> {
        return try {
            repository.getListNews(
                filter.name,
                date.name,
                sort.name
            )
        } catch (e: ConnectTimeoutException) {
            delay(2500)
            invoke(filter, date, sort)
        } catch (e: Exception) {
            emptyList()
        }
    }
}
