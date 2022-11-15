package app.seals.f32test.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavDirections
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.sampledata.DataPump
import app.seals.f32test.ui.screens.cart.CartScreen
import app.seals.f32test.ui.screens.details.ProductDetails
import app.seals.f32test.ui.screens.main.MainScreen
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
        composable(NavigationItem.Home.route) {
            vm.goMain()
            MainScreen(vm = vm, navController = navController)
        }
        composable(NavigationItem.Details.route) {
            vm.goDetails()
            ProductDetails(
                vm = vm,
                item = (vm.state.value as UiState.DetailsReady).item,
                onDismiss = { navController.popBackStack() },
                onCart = { navController.navigate(NavigationItem.Cart.route) }
            )
        }
        composable(NavigationItem.Cart.route) {
            vm.goCart()
            CartScreen(
                cart = DataPump.cartResponse,
                onDismiss = { navController.popBackStack() }
            )
        }
    }
}