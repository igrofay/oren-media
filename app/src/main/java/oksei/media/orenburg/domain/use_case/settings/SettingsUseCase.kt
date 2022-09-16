package oksei.media.orenburg.domain.use_case.settings

data class SettingsUseCase(
    val getSettingsApp: GetSettingsApp,
    val turnImagesInNews: TurnImagesInNews,
    val changeThemeApp: ChangeThemeApp,
    val changeScaleText: ChangeScaleText,
    val changeCity: ChangeCity,
)