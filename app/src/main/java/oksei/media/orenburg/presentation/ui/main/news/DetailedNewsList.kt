package oksei.media.orenburg.presentation.ui.main.news

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import oksei.media.orenburg.domain.model.DetailedNews
import oksei.media.orenburg.presentation.ui.widgets.list_collapsing_toolbar.ListCollapsingToolbar
import oksei.media.orenburg.ui.theme.ColorText
import oksei.media.orenburg.ui.theme.While900

@Composable
fun DetailedNewsList(
    news: DetailedNews?,
    close: ()-> Unit
) {
    AnimatedVisibility(
        visible = news != null,
        modifier = Modifier.fillMaxSize().background(colors.background),
        enter = fadeIn() ,  exit = fadeOut()
    ) {
        news?.run {
            ListCollapsingToolbar(
                urlImage = urlImage,
                header = header,
                onBack = close
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Row{
                        Text(
                            text = news.date,
                            modifier = Modifier
                                .border(1.dp, colors.primary)
                                .padding(6.dp),
                            color = colors.primary,
                            style = MaterialTheme.typography.subtitle2
                        )
                        Text(
                            text = stringResource(news.type.nameStringRes),
                            modifier = Modifier
                                .background(colors.primary)
                                .padding(6.dp),
                            color = While900,
                            style = MaterialTheme.typography.subtitle2
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = article,
                        style = MaterialTheme.typography.h5,
                        color = colors.ColorText
                    )
                }
            }
        }
    }
}