package oksei.media.orenburg.domain.use_case.settings

import oksei.media.orenburg.domain.model.SettingsApp
import oksei.media.orenburg.domain.repository.SettingsRepository

class ChangeScaleText(
    private val repository: SettingsRepository
) {
    operator fun invoke(scaleText: Float): SettingsApp {
        return repository.changeScaleText(scaleText)
    }
}