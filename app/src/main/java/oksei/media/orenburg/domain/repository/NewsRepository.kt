package oksei.media.orenburg.domain.repository

import oksei.media.orenburg.domain.model.DetailedNews
import oksei.media.orenburg.domain.model.NewsEvent

interface NewsRepository {
    suspend fun getListNews(filter: String, date: String, sort: String ) :List<NewsEvent>
    suspend fun getNewsById(id: String): DetailedNews
}