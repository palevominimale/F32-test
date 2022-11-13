package app.seals.f32test.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.screens.cart.CartScreen
import app.seals.f32test.ui.screens.details.ProductDetails
import app.seals.f32test.ui.screens.main.MainScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    vm: MainActivityViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(NavigationItem.Home.route) {
            MainScreen(
                vm = vm,
                navController = navController)
        }
        composable(NavigationItem.Details.route) {
            ProductDetails()
        }
        composable(NavigationItem.Cart.route) {
            CartScreen()
        }
    }
}