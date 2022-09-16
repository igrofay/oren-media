package oksei.media.orenburg.domain.use_case.settings

import oksei.media.orenburg.domain.model.SettingsApp
import oksei.media.orenburg.domain.repository.SettingsRepository

class TurnImagesInNews(
    private val repository: SettingsRepository
) {
    operator fun invoke(imageInNews: Boolean): SettingsApp {
        return repository.displayImagesInNews(imageInNews)
    }
}