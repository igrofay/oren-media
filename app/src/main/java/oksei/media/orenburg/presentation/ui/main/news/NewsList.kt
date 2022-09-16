package oksei.media.orenburg.presentation.ui.main.news

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import oksei.media.orenburg.domain.model.NewsEvent
import oksei.media.orenburg.ui.theme.ColorText

@Composable
fun NewsList(
    list: List<NewsEvent>,
    imagesInNews: Boolean,
    openNewsEvent: (id: String)-> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 15.dp),
    ) {
        itemsIndexed(list){ index, item ->
            NewsEventItem(
                news = item, imagesInNews = imagesInNews,
                openNewsEvent = {openNewsEvent(item.id)}
            )
            if (index != list.size-1){
                Spacer(modifier = Modifier.height(12.dp))
                Divider(color = MaterialTheme.colors.ColorText)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

