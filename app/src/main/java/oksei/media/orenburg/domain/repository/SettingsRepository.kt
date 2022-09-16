package oksei.media.orenburg.domain.repository

import oksei.media.orenburg.domain.model.SettingsApp

interface SettingsRepository {
    fun changeThemeApp(isDarkTheme: Boolean?) : SettingsApp
    fun changeScaleText(scaleText: Float): SettingsApp
    fun displayImagesInNews(imageInNews: Boolean): SettingsApp
    fun changeCity(city : String): SettingsApp
    fun getSettingsApp() : SettingsApp
}