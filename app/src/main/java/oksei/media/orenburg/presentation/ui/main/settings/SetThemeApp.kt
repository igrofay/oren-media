package oksei.media.orenburg.presentation.ui.main.settings

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import oksei.media.orenburg.R
import oksei.media.orenburg.ui.theme.ColorText


@Composable
fun SetThemeApp(
    isDartTheme: Boolean?,
    change:(Boolean?)->Unit
) {
    Column{
        Text(
            stringResource(R.string.theme),
            color = MaterialTheme.colors.ColorText,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W600
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected =  isDartTheme == true ,
                    onClick = { change(true) }
                )
                Text(
                    stringResource(R.string.dark),
                    color = MaterialTheme.colors.ColorText,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = isDartTheme == false ,
                    onClick = { change(false) }
                )
                Text(
                    stringResource(R.string.light),
                    color = MaterialTheme.colors.ColorText,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = isDartTheme == null,
                    onClick = { change(null) }
                )
                Text(
                    stringResource(R.string.system),
                    color = MaterialTheme.colors.ColorText,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}