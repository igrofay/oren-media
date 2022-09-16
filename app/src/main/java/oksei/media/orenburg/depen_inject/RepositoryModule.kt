package oksei.media.orenburg.depen_inject

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import oksei.media.orenburg.data.repository.NewsRepositoryImpl
import oksei.media.orenburg.data.repository.SettingsRepositoryImpl
import oksei.media.orenburg.data.repository.WeatherRepositoryImpl
import oksei.media.orenburg.domain.repository.NewsRepository
import oksei.media.orenburg.domain.repository.SettingsRepository
import oksei.media.orenburg.domain.repository.WeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepository(
        client : HttpClient
    ) : NewsRepository {
        return NewsRepositoryImpl(client)
    }
    @Singleton
    @Provides
    fun provideSettingsRepository(
        sh: SharedPreferences
    ) : SettingsRepository{
        return SettingsRepositoryImpl(sh)
    }
    @Singleton
    @Provides
    fun provideWeatherRepository(
        client : HttpClient
    ) : WeatherRepository {
        return WeatherRepositoryImpl(client)
    }
}