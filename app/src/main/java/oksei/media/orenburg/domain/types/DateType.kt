package oksei.media.orenburg.domain.types

import androidx.annotation.StringRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import oksei.media.orenburg.R

@Serializable
enum class DateType(@StringRes val nameStringRes: Int){
    @SerialName("AllTime") AllTime(R.string.all_time),
    @SerialName("Hour") Hour(R.string.hour),
    @SerialName("Day") Day(R.string.day),
    @SerialName("Week") Week(R.string.week),
    @SerialName("Month") Month(R.string.month),
    @SerialName("Year") Year(R.string.year)
}