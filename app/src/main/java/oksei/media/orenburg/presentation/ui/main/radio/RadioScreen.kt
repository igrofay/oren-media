package oksei.media.orenburg.presentation.ui.main.radio

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

val about = "<html><head><meta name=\"viewport\" content=\"width=device-width\"></head><body><video controls=\"\" autoplay=\"\" name=\"media\"><source src=\"http://fm.media56.ru:8000/Planeta\" type=\"audio/mpeg\"></video></body></html>"

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun RadioScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        AndroidView(factory = {
            WebView(it).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                settings.allowContentAccess = true
                settings.domStorageEnabled = true

                loadData(about, "text/html", "UTF-8")
            }
        })
    }
}