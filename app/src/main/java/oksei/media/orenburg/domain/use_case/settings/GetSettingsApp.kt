package oksei.media.orenburg.domain.use_case.settings

import oksei.media.orenburg.domain.model.SettingsApp
import oksei.media.orenburg.domain.repository.SettingsRepository

class GetSettingsApp(
    private val repository: SettingsRepository
) {
   operator fun invoke():SettingsApp{
       return repository.getSettingsApp()
   }
}