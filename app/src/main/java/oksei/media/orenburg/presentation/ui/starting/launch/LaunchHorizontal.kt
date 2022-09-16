package oksei.media.orenburg.presentation.ui.starting.launch

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import oksei.media.orenburg.R
import oksei.media.orenburg.ui.theme.ColorText
import oksei.media.orenburg.ui.theme.PrimaryVariantDay
import oksei.media.orenburg.ui.theme.While900

@Composable
fun LaunchHorizontal(textApp: String, scaleIconApp : Float) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_radio),
            contentDescription = null,
            modifier = Modifier.scale(scaleIconApp).size(150.dp,150.dp),
            tint = MaterialTheme.colors.secondaryVariant
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = textApp,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.ColorText,
        )
    }
}