@file:Suppress("CAST_NEVER_SUCCEEDS")

package app.seals.f32test.ui.screens.main

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.navigation.NavController
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.sampledata.DataPump
import app.seals.f32test.ui.screens.details.ProductDetails
import app.seals.f32test.ui.states.UiState

@Composable
fun MainScreen(vm: MainActivityViewModel, navController: NavController) {
    val state = vm.state.collectAsState()
    when(state.value) {
        is UiState.MainReady -> {
                ShowMainScreen(
                    uiState = state.value as UiState.MainReady,
                    vm = vm)
            }
        is UiState.DetailsReady -> {
            ProductDetails(
                item = (state.value as UiState.DetailsReady).item,
                vm = vm
            )
        }
        else -> {}
    }
}

@Composable
private fun ShowMainScreen(
    uiState: UiState.MainReady,
    vm: MainActivityViewModel = DataPump.vm
) {
    val state = rememberLazyListState(initialFirstVisibleItemIndex = 0)
    val showFilterDialog = remember { mutableStateOf(false)}

    LazyColumn(
        state = state
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
        item { HotSales(uiState.hotSales) }
        item { BestSeller(uiState.bestSeller) { vm.select(it) } }

    }
}


