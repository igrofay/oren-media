package oksei.media.orenburg.data.repository

import android.content.SharedPreferences
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import oksei.media.orenburg.domain.model.SettingsApp
import oksei.media.orenburg.domain.repository.SettingsRepository

class SettingsRepositoryImpl(
    val sh : SharedPreferences
) : SettingsRepository {
    private val keySettingsApp = "SettingsApp"

    override fun changeThemeApp(isDarkTheme: Boolean?): SettingsApp  {
        sh.getString(keySettingsApp, null)?.let {
            return Json.decodeFromString<SettingsApp>(it).apply {
                this.isDarkTheme = isDarkTheme
                sh.edit().putString(keySettingsApp, Json.encodeToString(this)).apply()
            }
        }
        throw NullPointerException("Не найден SettingsApp")
    }

    override fun changeScaleText(scaleText: Float) : SettingsApp{
        sh.getString(keySettingsApp, null)?.let {
            return Json.decodeFromString<SettingsApp>(it).apply {
                this.scaleText = scaleText
                sh.edit().putString(keySettingsApp, Json.encodeToString(this)).apply()
            }
        }
        throw NullPointerException("Не найден SettingsApp")
    }

    override fun displayImagesInNews(imageInNews: Boolean): SettingsApp {
        sh.getString(keySettingsApp, null)?.let {
            return Json.decodeFromString<SettingsApp>(it).apply {
                this.imageInNews = imageInNews
                sh.edit().putString(keySettingsApp, Json.encodeToString(this)).apply()
            }
        }
        throw NullPointerException("Не найден SettingsApp")
    }

    override fun changeCity(city: String) : SettingsApp{
        sh.getString(keySettingsApp, null)?.let {
            return Json.decodeFromString<SettingsApp>(it).apply {
                this.city = city
                sh.edit().putString(keySettingsApp, Json.encodeToString(this)).apply()
            }
        }
        throw NullPointerException("Не найден SettingsApp")
    }

    override fun getSettingsApp(): SettingsApp {
        sh.getString(keySettingsApp, null)?.let {
            return Json.decodeFromString(it)
        }
        return SettingsApp(isDarkTheme = null, scaleText = 1.0f, true, "Оренбург").also {
            sh.edit().putString(keySettingsApp, Json.encodeToString(it)).apply()
        }
    }

}