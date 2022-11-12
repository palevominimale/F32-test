package app.seals.f32test.ui.screens.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.screens.main.search.SearchField
import java.util.logging.Filter

@Composable
fun MainScreen(vm: MainActivityViewModel) {
    val state = rememberLazyListState(initialFirstVisibleItemIndex = 0)
    LazyColumn(
        state = state
    ) {
        item { LocationAndFilter() }
        item { CategoriesSelector(vm) }
        item { SearchField() }
        item { HotSales(vm) }
        item { FilterOptions(vm) }
        item { BestSeller(vm) }
    }
}