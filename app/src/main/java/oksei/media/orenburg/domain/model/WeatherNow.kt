package oksei.media.orenburg.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherNow(
    val localtime: String,
    val icon: String,
    val temp_c: String,
    val is_day: Boolean,
    val humidity: String,
    val wind_kph: String,
    val pressure_mb: String
)
