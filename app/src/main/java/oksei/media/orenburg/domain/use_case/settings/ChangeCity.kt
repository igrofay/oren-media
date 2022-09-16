package oksei.media.orenburg.domain.use_case.settings

import oksei.media.orenburg.domain.model.SettingsApp
import oksei.media.orenburg.domain.repository.SettingsRepository

class ChangeCity(
    private val repository: SettingsRepository
) {
    operator fun invoke(city: String): SettingsApp {
        return repository.changeCity(city)
    }
}