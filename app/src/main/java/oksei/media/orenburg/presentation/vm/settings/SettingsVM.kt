package oksei.media.orenburg.presentation.vm.settings

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import oksei.media.orenburg.domain.model.SettingsApp
import oksei.media.orenburg.domain.repository.SettingsRepository
import oksei.media.orenburg.domain.use_case.settings.SettingsUseCase
import javax.inject.Inject

@HiltViewModel
class SettingsVM @Inject constructor(
    private val useCase: SettingsUseCase
): ViewModel() {
    private var _state = mutableStateOf(useCase.getSettingsApp())
    val state: State<SettingsApp> = _state

    fun onEvent(event: SettingsEvent){
        when(event){
            is SettingsEvent.ChangeCity -> {
                _state.value = useCase.changeCity(event.city)
            }
            is SettingsEvent.ChangeScaleText -> {
                _state.value = useCase.changeScaleText(event.scaleText)
            }
            is SettingsEvent.ChangeThemeApp -> {
                _state.value = useCase.changeThemeApp(event.isDarkTheme)
            }
            is SettingsEvent.DisplayImagesInNews -> {
                _state.value = useCase.turnImagesInNews(event.imageInNews)
            }
        }
    }
}