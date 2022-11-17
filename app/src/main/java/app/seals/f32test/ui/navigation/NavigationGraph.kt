package app.seals.f32test.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.seals.f32test.main.vm.MainActivityViewModel
import app.seals.f32test.ui.screens.cart.CartScreen
import app.seals.f32test.ui.screens.details.ProductDetails
import app.seals.f32test.ui.screens.main.MainScreen
import app.seals.f32test.ui.screens.splash.SplashScreen
import app.seals.f32test.ui.states.UiState

@Composable
fun NavigationGraph(
    navController: NavHostController,
    vm: MainActivityViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(NavigationItem.Splash.route) {
            SplashScreen()
        }
        composable(NavigationItem.Home.route) {
            vm.goMain()
            MainScreen(vm = vm, navController = navController)
        }
        composable(NavigationItem.Details.route) {
            vm.goDetails()
            if(vm.state.value is UiState.DetailsReady) {
                val item = (vm.state.value as UiState.DetailsReady).item
                ProductDetails(
                    item = item,
                    onDismiss = { navController.popBackStack() },
                    onCart = { navController.navigate(NavigationItem.Cart.route) }
                )
            }

        }
        composable(NavigationItem.Cart.route) {
            vm.goCart()
            if(vm.state.value is UiState.CartReady) {
                val cart = (vm.state.value as UiState.CartReady).cart
                CartScreen(
                    cart = cart,
                    onDismiss = { navController.popBackStack() }
                )
            }
        }
    }
}