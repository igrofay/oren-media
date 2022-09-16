package oksei.media.orenburg.domain.types

import androidx.annotation.StringRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import oksei.media.orenburg.R

@Serializable
enum class NewsType(@StringRes val nameStringRes: Int){
    @SerialName("All") All(R.string.all),
    @SerialName("Society")  Society(R.string.society),
    @SerialName("Sport") Sport(R.string.sport),
    @SerialName("Culture") Culture(R.string.culture),
    @SerialName("Economy") Economy(R.string.economy),
    @SerialName("Politics") Politics(R.string.politics)
}
