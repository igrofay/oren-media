package oksei.media.orenburg.domain.repository

import oksei.media.orenburg.domain.model.WeatherNow

interface WeatherRepository {
    suspend fun getWeatherNow(city: String): WeatherNow
}