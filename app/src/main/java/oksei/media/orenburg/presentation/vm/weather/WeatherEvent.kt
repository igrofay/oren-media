package oksei.media.orenburg.presentation.vm.weather

sealed class WeatherEvent {
    object UpdateWeatherNow : WeatherEvent()
}