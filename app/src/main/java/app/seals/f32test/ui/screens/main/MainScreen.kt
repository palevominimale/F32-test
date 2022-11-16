package app.seals.f32test.ui.screens.main

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*
import androidx.navigation.NavController
import app.seals.f32test.main.vm.MainActivityViewModel
import app.seals.f32test.ui.navigation.NavigationItem
import app.seals.f32test.ui.states.UiState

@Composable
fun MainScreen(
    vm: MainActivityViewModel,
    navController: NavController
) {
    ShowMainScreen(
        uiState = vm.state.value as UiState.MainReady,
        navController = navController,
        vm.listStateStorage
    )
}

@Composable
private fun ShowMainScreen(
    uiState: UiState.MainReady,
    navController: NavController,
    listStateStorage: LazyListState
) {
    val showFilterDialog = remember { mutableStateOf(false) }
    LazyColumn(
        state = listStateStorage
    ) {
        if (showFilterDialog.value) item {
            FilterOptions(
                show = showFilterDialog.value,
                onDismiss = { showFilterDialog.value = false },
            )
        }
        item { LocationAndFilter { showFilterDialog.value = true } }
        Log.e("MS_", "$showFilterDialog")
        item { CategoriesSelector(uiState.categories) }
        item { SearchField() }
        item { HotSales(uiState.apiResponse?.homeStore ?: emptyList()) }
        item {
            BestSeller(uiState.apiResponse?.bestSeller ?: emptyList()) {
                navController.navigate(NavigationItem.Details.route)
            }
        }
    }
}


