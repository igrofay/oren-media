package oksei.media.orenburg.presentation.ui.starting.launch

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun AnimateInputText(
    text: String,
    newText: (String)-> Unit
) {
    LaunchedEffect(text){
        for (i in text.indices){
            newText(text.slice(0..i))
            delay(250)
        }
    }
}