package oksei.media.orenburg.depen_inject

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.resources.*
import io.ktor.serialization.kotlinx.json.*
import oksei.media.orenburg.domain.repository.NewsRepository
import oksei.media.orenburg.domain.repository.SettingsRepository
import oksei.media.orenburg.domain.repository.WeatherRepository
import oksei.media.orenburg.domain.use_case.news.GetDetailedNews
import oksei.media.orenburg.domain.use_case.news.GetListNewsEvent
import oksei.media.orenburg.domain.use_case.news.NewsUseCase
import oksei.media.orenburg.domain.use_case.settings.*
import oksei.media.orenburg.domain.use_case.weather.GetWeatherNow
import oksei.media.orenburg.domain.use_case.weather.WeatherUseCase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val urlServer = "https://43f5-136-169-243-169.ngrok.io"
    private const val keySharedPreferences = "keySharedPreferences"
    @Provides
    @Singleton
    fun provideHttpClient() : HttpClient {
        return HttpClient(CIO){
            install(Resources)
            install(HttpRequestRetry) {
                retryOnServerErrors(maxRetries = 5)
                exponentialDelay()
            }
            install(HttpCache)
            install(ContentNegotiation) {
                json()
            }
            expectSuccess = true
            defaultRequest{
                url(urlServer)
            }
        }
    }
    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application) : SharedPreferences {
        return app.getSharedPreferences(keySharedPreferences, Context.MODE_PRIVATE)
    }
    @Provides
    @Singleton
    fun provideNewsUseCase(repository: NewsRepository): NewsUseCase{
        return NewsUseCase(
            GetListNewsEvent(repository),
            GetDetailedNews(repository)
        )
    }
    @Provides
    @Singleton
    fun provideSettingsUseCase(repository: SettingsRepository): SettingsUseCase {
        return SettingsUseCase(
            GetSettingsApp(repository),
            TurnImagesInNews(repository),
            ChangeThemeApp(repository),
            ChangeScaleText(repository),
            ChangeCity(repository)
        )
    }
    @Provides
    @Singleton
    fun provideWeatherUseCase(repository: WeatherRepository): WeatherUseCase{
        return WeatherUseCase(
            GetWeatherNow(repository)
        )
    }
}