package oksei.media.orenburg.domain.use_case.news

import oksei.media.orenburg.domain.model.DetailedNews
import oksei.media.orenburg.domain.model.NewsEvent
import oksei.media.orenburg.domain.repository.NewsRepository

class GetDetailedNews(
    private val repository: NewsRepository
){
    suspend operator fun invoke(id:String): DetailedNews{
        return repository.getNewsById(id)
    }
}