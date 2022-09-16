package oksei.media.orenburg.domain.model

import kotlinx.serialization.Serializable
import oksei.media.orenburg.domain.types.NewsType

@Serializable
data class DetailedNews(
    val id: String,
    val type : NewsType,
    val header: String,
    val date: String,
    val urlImage: String? = null,
    val article : String,
)
