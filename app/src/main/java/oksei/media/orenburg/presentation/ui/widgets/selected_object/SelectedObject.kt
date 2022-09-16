package oksei.media.orenburg.presentation.ui.widgets.selected_object

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import oksei.media.orenburg.ui.theme.While900

@Composable
fun SelectedObject(
    text : String,
    selected: Boolean,
    onChange : ()-> Unit,
    width: Dp
) {
    val modifierBox = if (selected) Modifier.width(width).clip(CircleShape).background(colors.primary, CircleShape)
    else Modifier.width(width).clip(CircleShape).border(1.dp, colors.primary, CircleShape)
    Box(
        modifier = modifierBox.clickable(onClick = onChange).padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (selected) While900 else colors.primary,
            style = MaterialTheme.typography.subtitle2
        )
    }
}