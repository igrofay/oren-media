package oksei.media.orenburg.presentation.navigation

sealed class RoutingApp(val route: String) {
    object Starting : RoutingApp("StartingRoute")
    object Main : RoutingApp("MainRoute")
}