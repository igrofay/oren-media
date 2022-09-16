package oksei.media.orenburg.data.datasourse.net

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource("/news")
class NewsResources(
    val filter: String? = null,
    val date: String? = null,
    val sort: String? = null
) {
    @Serializable
    @Resource("{id}")
    class Id(val parent: NewsResources = NewsResources(), val id: String)
}