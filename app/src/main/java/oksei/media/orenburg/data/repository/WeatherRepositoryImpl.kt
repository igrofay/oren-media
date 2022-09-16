package oksei.media.orenburg.data.repository

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.resources.*
import oksei.media.orenburg.data.datasourse.net.WeatherResources
import oksei.media.orenburg.domain.model.WeatherNow
import oksei.media.orenburg.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val client: HttpClient
) : WeatherRepository {
    override suspend fun getWeatherNow(city: String): WeatherNow {
        return client.get(WeatherResources.Now.City(city = city)).body()
    }
}