package oksei.media.orenburg.presentation.ui.starting.launch

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun AnimateIconApp(
    newScale: (Float)-> Unit
) {
    LaunchedEffect(true ){
        var isIncrease = true
        var last = 1f
        while (true){
            if (isIncrease){
                last += 0.01f
                newScale(last)
                if (last >=1.1f) isIncrease = false
            }else{
                last -= 0.01f
                newScale(last)
                if (last <= 0.9f) isIncrease = true
            }
            delay(50)
        }
    }
}