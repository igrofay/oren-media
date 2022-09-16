package oksei.media.orenburg.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import oksei.media.orenburg.domain.types.NewsType

@Serializable
data class NewsEvent(
    val id: String,
    val type : NewsType,
    val header: String,
    val date: String,
    val urlImage: String? = null
)
