package oksei.media.orenburg.presentation.vm.settings

sealed class SettingsEvent{
    data class ChangeThemeApp(val isDarkTheme: Boolean?) : SettingsEvent()
    data class ChangeScaleText(val scaleText: Float) : SettingsEvent()
    data class DisplayImagesInNews(val imageInNews: Boolean): SettingsEvent()
    data class ChangeCity(val city: String) : SettingsEvent()
}
