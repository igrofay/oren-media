package oksei.media.orenburg.presentation.ui.main.weather

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import oksei.media.orenburg.R
import oksei.media.orenburg.domain.model.WeatherNow
import oksei.media.orenburg.ui.theme.ColorText

@Composable
fun WeatherNowInfo(
    weatherNow: WeatherNow,
    city:String
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.3f))
        Text(
            text = city,
            style = typography.h4,
            fontWeight = FontWeight.Light
        )
        Text(
            text = weatherNow.localtime,
            style = typography.subtitle1,
            fontWeight = FontWeight.ExtraLight
        )
        Spacer(modifier = Modifier.weight(0.35f))
        GlideImage(
            imageModel = weatherNow.icon,
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.weight(0.4f))
        Text(
            text = weatherNow.temp_c.split('.').first() + "°C",
            style =  typography.h3
        )
        Text(
            text = if (weatherNow.is_day) stringResource(R.string.good_day)
            else stringResource(R.string.good_night),
            style = typography.subtitle1,
            fontWeight = FontWeight.ExtraLight
        )
        Divider(
            color = colors.ColorText.copy(0.8f),
            modifier = Modifier
                .padding(vertical = 28.dp)
                .width(26.dp)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth(0.9f),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_barometer),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.pressure),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
                Text(
                    text = weatherNow.pressure_mb + " " +stringResource(R.string.mb),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            }
            Divider(
                    color = colors.ColorText.copy(0.8f),
            modifier = Modifier
                .width(26.dp)
                .rotate(90f)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_wind),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.wind),
                    maxLines = 1,
                    overflow = TextOverflow.Clip

                )
                Text(
                    text = weatherNow.wind_kph + " " + stringResource(R.string.kph),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            }
            Divider(
                color = colors.ColorText.copy(0.8f),
                modifier = Modifier
                    .width(26.dp)
                    .rotate(90f)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_humidity),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.humidity),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
                Text(
                    text = weatherNow.humidity + " %",
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.35f))
    }
}