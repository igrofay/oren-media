package oksei.media.orenburg.presentation.ui.main.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import oksei.media.orenburg.R
import oksei.media.orenburg.presentation.vm.settings.SettingsEvent
import oksei.media.orenburg.ui.theme.ColorText

@Composable
fun SetScaleText(
    scaleText: Float,
    change: (Float)-> Unit
) {
    Column {
        Text(
            stringResource(R.string.text_size),
            color = MaterialTheme.colors.ColorText,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W600
        )
        Slider(
            value = scaleText - 0.5f,
            onValueChange = { change(it+0.5f)} ,
            modifier = Modifier.fillMaxWidth()
        )
    }
}