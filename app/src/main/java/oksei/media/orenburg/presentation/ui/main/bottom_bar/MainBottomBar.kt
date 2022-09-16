package oksei.media.orenburg.presentation.ui.main.bottom_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults.BottomAppBarElevation
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import oksei.media.orenburg.presentation.navigation.RoutingMain

@Composable
fun MainBottomBar(
    navHost: NavHostController,
    listRouting: List<RoutingMain>,
    onClick: (String) -> Unit
) {
    val navBackStackEntry by navHost.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Row(
        modifier = Modifier
            .shadow(BottomAppBarElevation)
            .fillMaxWidth()
            .background(colors.background)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listRouting.forEach {
            BottomNavItem(
                selected = currentDestination?.hierarchy?.any { item -> it.route == item.route } == true,
                onClick = { onClick(it.route) },
                iconRes = it.iconRes,
                labelRes = it.strRes
            )
        }
    }
}