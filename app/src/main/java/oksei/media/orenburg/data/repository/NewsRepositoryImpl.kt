package oksei.media.orenburg.data.repository

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.resources.*
import oksei.media.orenburg.data.datasourse.net.NewsResources
import oksei.media.orenburg.domain.model.DetailedNews
import oksei.media.orenburg.domain.model.NewsEvent
import oksei.media.orenburg.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val client : HttpClient
) : NewsRepository {
    override suspend fun getListNews(
        filter: String,
        date: String,
        sort: String
    ): List<NewsEvent> {
        return client.get(NewsResources(filter, date, sort)).body()
    }
    override suspend fun getNewsById(id: String): DetailedNews {
        return client.get(NewsResources.Id(id = id)).body()
    }
}