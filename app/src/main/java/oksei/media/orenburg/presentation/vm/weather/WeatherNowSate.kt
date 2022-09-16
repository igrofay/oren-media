package oksei.media.orenburg.presentation.vm.weather

sealed class WeatherNowSate {
    object LoadingData : WeatherNowSate()
    object HaveData : WeatherNowSate()
    object NoHaveData : WeatherNowSate()
}