package app.seals.f32test.ui.screens.main

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.screens.main.search.SearchField

@Composable
fun MainScreen(vm: MainActivityViewModel) {
    val state = rememberLazyListState(initialFirstVisibleItemIndex = 0)
    val showFilterDialog = remember { mutableStateOf(false)}

    LazyColumn(
        state = state
    ) {
        item { LocationAndFilter { showFilterDialog.value = true } }
        Log.e("MS_", "$showFilterDialog")
        if (showFilterDialog.value) item {
            FilterOptions(
                show = showFilterDialog.value,
                onDismiss = {
                    showFilterDialog.value = false
                            },
            )}
        item { CategoriesSelector(vm) }
        item { SearchField() }
        item { HotSales(vm) }
        item { BestSeller(vm) }
    }
}


