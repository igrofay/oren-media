package oksei.media.orenburg.presentation.ui.starting.launch

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import oksei.media.orenburg.R
import oksei.media.orenburg.presentation.ui.widgets.search_data.AnimateSearch
import oksei.media.orenburg.ui.theme.ColorText
import oksei.media.orenburg.ui.theme.PrimaryVariantDay
import oksei.media.orenburg.ui.theme.While900

@Composable
fun LaunchVertical(textApp: String, scaleIconApp : Float) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_radio),
            contentDescription = null,
            modifier = Modifier.scale(scaleIconApp).size(130.dp,130.dp),
            tint = colors.secondaryVariant
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = textApp,
            style = MaterialTheme.typography.h4,
            color =colors.ColorText,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
    }
}