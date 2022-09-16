package oksei.media.orenburg.presentation.ui.widgets.list_collapsing_toolbar

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.math.MathUtils

@Composable
fun ListCollapsingToolbar(
    urlImage : String?,
    header : String,
    onBack : ()-> Unit,
    content: @Composable ()-> Unit
) {

    val stateList = rememberLazyListState()
    val screenWidthDp = LocalConfiguration.current.screenWidthDp/2
    val maxToolbar = MathUtils.clamp(screenWidthDp, 200.dp.value.toInt(), 800.dp.value.toInt()).dp
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 30.dp),
            state = stateList
        ){
            item {
                Spacer(Modifier.height(maxToolbar))
            }
            item {
                content()
            }
        }
        CollapsingToolbar(
            urlImage = urlImage,
            title = header,
            stateList = stateList,
            maxHeight = maxToolbar
        )
    }
    BackHandler(onBack = onBack)
}