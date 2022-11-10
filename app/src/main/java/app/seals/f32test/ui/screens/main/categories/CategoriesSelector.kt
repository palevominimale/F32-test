@file:Suppress("UNCHECKED_CAST")

package app.seals.f32test.ui.screens.main.categories

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.seals.f32test.ui.main.MainActivityViewModel
import app.seals.f32test.ui.models.categories.CategoryItemModel
import app.seals.f32test.ui.states.UiState.IsLoading
import app.seals.f32test.ui.states.UiState.IsReady

@Composable
fun CategoriesSelector(vm: MainActivityViewModel) {

    val state by vm.state.collectAsState(IsLoading)

    when (state) {
        is IsReady -> CategoriesRow(
            list = (state as IsReady).items as List<CategoryItemModel>,
            selected = (state as IsReady).selected,
            placeholders = false)
        else -> {}
    }
}

@Composable
fun CategoriesRow(list: List<CategoryItemModel>, selected: String?, placeholders: Boolean) {
    Surface(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        LazyRow {
            itemsIndexed(list) { _, it ->
                CategoryItem(item = it, placeholders = placeholders, selected = it.title == selected)
            }
        }
    }
}