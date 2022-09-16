package oksei.media.orenburg.domain.use_case.settings

import oksei.media.orenburg.domain.model.SettingsApp
import oksei.media.orenburg.domain.repository.SettingsRepository

class ChangeThemeApp(
    private val repository: SettingsRepository
) {
    operator fun invoke(isDarkTheme: Boolean?): SettingsApp {
        return repository.changeThemeApp(isDarkTheme)
    }
}