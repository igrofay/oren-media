package oksei.media.orenburg.presentation.ui.main.bottom_bar


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import oksei.media.orenburg.ui.theme.ColorText

@Composable
fun BottomNavItem(
    selected: Boolean,
    onClick: () -> Unit,
    @DrawableRes iconRes:  Int,
    @StringRes labelRes: Int
) {
    val background = if (selected) MaterialTheme.colors.secondary.copy(0.2f) else Color.Transparent
    val contentColor = if(selected) MaterialTheme.colors.secondary else MaterialTheme.colors.ColorText
    Box(
        Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ){
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            Icon(painterResource(iconRes), contentDescription = null, tint = contentColor )
            AnimatedVisibility(visible = selected) {
                Text(
                    stringResource(labelRes),
                    color = contentColor, style = MaterialTheme.typography.body2
                )
            }
        }
    }
}