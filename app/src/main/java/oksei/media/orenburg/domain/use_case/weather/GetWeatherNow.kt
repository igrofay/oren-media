package oksei.media.orenburg.domain.use_case.weather

import android.util.Log
import io.ktor.client.network.sockets.*
import kotlinx.coroutines.delay
import oksei.media.orenburg.domain.model.WeatherNow
import oksei.media.orenburg.domain.repository.WeatherRepository

class GetWeatherNow(
    private val repository: WeatherRepository
){
    suspend operator fun invoke(city: String) : WeatherNow?{
        return try {
            repository.getWeatherNow(city)
        }catch(e: ConnectTimeoutException) {
            delay(2500)
            invoke(city)
        }catch (e: Exception){
            null
        }
    }
}