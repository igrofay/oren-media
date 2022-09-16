package oksei.media.orenburg.presentation.ui.widgets.search_data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.*

@Composable
fun AnimateSearch(
    newOffset: (x: Dp,y : Dp)->Unit
) {
    LaunchedEffect(true ){
        launch(Dispatchers.Default) {
            var t = Double.MIN_VALUE
            val c_sqrt2 = 80.dp.value * sqrt(2.0)
            while (true){
                val sinT = sin(t)
                val c_sqrt2_cosT= c_sqrt2 * cos(t)
                val denominator = (1 + sinT*sinT)
                val x = ((c_sqrt2_cosT)/ denominator).dp
                val y = ((c_sqrt2_cosT * sinT)/ denominator).dp
                t+=0.01
                newOffset(x,y)
                delay(10)
            }
        }
    }
}