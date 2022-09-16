package oksei.media.orenburg.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SettingsApp(
    var isDarkTheme: Boolean?,
    var scaleText: Float,
    var imageInNews: Boolean,
    var city: String
)