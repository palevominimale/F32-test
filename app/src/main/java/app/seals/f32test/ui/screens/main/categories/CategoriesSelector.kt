@file:Suppress("UNCHECKED_CAST")

package app.seals.f32test.ui.screens.main.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import app.seals.f32test.R
import app.seals.f32test.ui.main.vm.MainActivityViewModel
import app.seals.f32test.ui.models.categories.CategoryItemModel
import app.seals.f32test.ui.states.UiState.IsLoading
import app.seals.f32test.ui.states.UiState.IsReady
import app.seals.f32test.ui.theme.Typography

@Composable
fun CategoriesSelector(vm: MainActivityViewModel) {

    val state by vm.state.collectAsState(IsLoading)

    when (state) {
        is IsReady -> CategoriesRow(
            list = (state as IsReady).categories,
            selected = (state as IsReady).selectedCategory,
            placeholders = false)
        else -> {}
    }
}

@Composable
fun CategoriesRow(list: List<CategoryItemModel>, selected: String?, placeholders: Boolean) {
    Surface(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Column {

            Text(
                text = stringResource(id = R.string.main_select_category),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                style = Typography.bodyLarge
            )
            LazyRow {
                itemsIndexed(list) { _, it ->
                    CategoryItem(item = it, placeholders = placeholders, selected = it.title == selected)
                }
            }
        }

    }
}