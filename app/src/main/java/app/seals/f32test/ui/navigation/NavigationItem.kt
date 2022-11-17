package app.seals.f32test.ui.navigation

sealed class NavigationItem (var title: String, var route: String) {
    object Home : NavigationItem("Home", "home")
    object Splash : NavigationItem("Splash", "splash")
    object Cart : NavigationItem("Cart", "cart")
    object Details : NavigationItem("Details", "details")
}