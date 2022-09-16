package oksei.media.orenburg.domain.types

import androidx.annotation.StringRes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import oksei.media.orenburg.R

@Serializable
enum class SortType(@StringRes val nameStringRes: Int) {
    @SerialName("New") New(R.string.new_),
    @SerialName("Old") Old(R.string.old)
}