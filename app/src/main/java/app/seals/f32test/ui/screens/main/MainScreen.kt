package app.seals.f32test.ui.screens.main

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.navigation.NavigationItem
import app.seals.f32test.ui.states.UiState

@Composable
fun MainScreen(vm: MainActivityViewModel, navController: NavController) {
    val state = vm.state.collectAsState()
    when(state.value) {
        is UiState.IsReady -> {
            if((state.value as UiState.IsReady).selectedItem == -1) {
                ShowMainScreen(vm)
            } else {
                navController.navigate(NavigationItem.Details.route)
            }
        }
        else -> {}
    }
}

@Composable
private fun ShowMainScreen(vm: MainActivityViewModel) {
    val state = rememberLazyListState(initialFirstVisibleItemIndex = 0)
    val showFilterDialog = remember { mutableStateOf(false)}
    LazyColumn(
        state = state
    ) {

        if (showFilterDialog.value) item {
            FilterOptions(
                show = showFilterDialog.value,
                onDismiss = { showFilterDialog.value = false },
            )}
        item { LocationAndFilter { showFilterDialog.value = true } }
        Log.e("MS_", "$showFilterDialog")
        item { CategoriesSelector(vm) }
        item { SearchField() }
        item { HotSales(vm) }
        item { BestSeller(vm) }
    }
}


