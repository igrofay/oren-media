package oksei.media.orenburg.presentation.ui.widgets.list_collapsing_toolbar

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import oksei.media.orenburg.ui.theme.While900


@Composable
fun CollapsingToolbar(
    urlImage: String?,
    title: String,
    stateList: LazyListState,
    maxHeight: Dp
) {
    val minToolbar = 56.dp
    val maxOffset = maxHeight - minToolbar
    val offset = with(LocalDensity.current){
        if (stateList.firstVisibleItemIndex == 0 && stateList.firstVisibleItemScrollOffset <= maxOffset.roundToPx() )
            stateList.firstVisibleItemScrollOffset.toDp()
        else maxOffset
    }
    val offsetProgress = max(0.dp , offset * 2 - maxOffset ) /maxOffset
    TopAppBar(
        contentPadding = PaddingValues(),
        modifier = Modifier
            .height(maxHeight)
            .offset(y = -offset)
            .scrollable(stateList, Orientation.Vertical),
        backgroundColor = colors.primary
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            androidx.compose.animation.AnimatedVisibility(
                offset < maxHeight / 3f ,
                Modifier
                    .fillMaxWidth()
                    .height(maxHeight - offset)
                    .align(Alignment.BottomCenter),
                enter = fadeIn() ,  exit = fadeOut()
            ){
                Box(modifier = Modifier.fillMaxSize()){
                    GlideImage(
                        imageModel = urlImage ,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                    urlImage?.let { Spacer(
                        Modifier
                            .fillMaxWidth()
                            .height(maxHeight +30.dp)
                            .background(
                                Brush.verticalGradient(
                                    listOf(Color.Transparent, Color.Black)
                                )
                            )
                            .align(Alignment.BottomCenter)) }

                }
            }
            Row(
                Modifier
                    .padding(bottom = (12 - 12 * offsetProgress).dp, start = (30 - 30*offsetProgress).dp, end = (10 - 10*offsetProgress).dp)
                    .height(minToolbar)
                    .align(Alignment.BottomStart), verticalAlignment = Alignment.CenterVertically) {

                Text(title ,
                    Modifier
                        .offset(x= -(title.length*offsetProgress).dp)
                        .scale(1f - 0.4f * offsetProgress),
                    fontSize = 32.sp , maxLines = 1 ,
                    fontWeight = if (offsetProgress==1f) FontWeight.Bold else null  , color = While900,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}