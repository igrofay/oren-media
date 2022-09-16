package oksei.media.orenburg.data.datasourse.net

import io.ktor.resources.*
import kotlinx.serialization.Serializable
import oksei.media.orenburg.domain.repository.WeatherRepository

@Serializable
@Resource("/weather")
class WeatherResources {
    @Serializable
    @Resource("now")
    class Now(val parent: WeatherResources = WeatherResources()){
        @Serializable
        @Resource("{city}")
        class City(val parent: Now = Now(), val city: String)

    }
}