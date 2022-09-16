package oksei.media.orenburg.presentation.ui.main.news

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.math.MathUtils
import com.skydoves.landscapist.glide.GlideImage
import oksei.media.orenburg.domain.model.NewsEvent
import oksei.media.orenburg.ui.theme.While900

@Composable
fun NewsEventItem(
    news : NewsEvent,
    imagesInNews: Boolean,
    openNewsEvent: ()->Unit
) {
    Column(
        Modifier.fillMaxWidth().clickable(onClick = openNewsEvent).padding(2.dp)
    ){
        if (imagesInNews && news.urlImage!= null ){
            val screenWidthDp = LocalConfiguration.current.screenWidthDp/2
            val height = MathUtils.clamp(screenWidthDp, 200.dp.value.toInt(), 800.dp.value.toInt()).dp
            GlideImage(
                imageModel = news.urlImage,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Row{
            Text(
                text = news.date,
                modifier = Modifier
                    .border(1.dp, colors.primary)
                    .padding(6.dp),
                color = colors.primary,
                style = typography.subtitle2
            )
            Text(
                text = stringResource(news.type.nameStringRes),
                modifier = Modifier
                    .background(colors.primary)
                    .padding(6.dp),
                color = While900,
                style = typography.subtitle2
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = news.header,
            style = typography.subtitle1
        )
    }
}