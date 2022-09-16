package oksei.media.orenburg.presentation.ui.main.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import oksei.media.orenburg.R
import oksei.media.orenburg.ui.theme.ColorText

@Composable
fun TurnImageInNews(
    isTurnOn: Boolean,
    change: (Boolean)->Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            stringResource(R.string.image_in_news),
            color = colors.ColorText,
            modifier = Modifier.fillMaxWidth(0.7f)
        )
        Switch(
            checked = isTurnOn,
            onCheckedChange =  change,
            colors = SwitchDefaults.colors(
                checkedThumbColor = colors.secondary ,
                checkedTrackColor = colors.secondary ,
                uncheckedThumbColor = colors.ColorText,
                uncheckedTrackColor = colors.ColorText,
            )
        )
    }
}