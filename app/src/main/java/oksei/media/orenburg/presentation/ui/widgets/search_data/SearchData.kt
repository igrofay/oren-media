package oksei.media.orenburg.presentation.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import oksei.media.orenburg.presentation.ui.widgets.search_data.AnimateSearch

@Composable
fun SearchData() {
    var x by remember {
        mutableStateOf(0.dp)
    }
    var y by remember {
        mutableStateOf(0.dp)
    }
    AnimateSearch{ _x, _y->
        x= _x
        y=_y
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .offset(x,y),
            tint = colors.secondaryVariant
        )
    }
}
