package oksei.media.orenburg.presentation.ui.widgets.no_have_data

import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import oksei.media.orenburg.R

@Composable
fun NoHaveData(
    resetData: (()->Unit)? = null
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colors.secondaryVariant
            )
            Text(
                stringResource(R.string.no_have_data),
                fontWeight = FontWeight.W600,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
        resetData?.let {
            FloatingActionButton(
                onClick = it,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(-25.dp, -25.dp)
            ) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
            }
        }
    }

}