package app.seals.f32test.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import app.seals.f32test.ui.main.MainActivityViewModel
import app.seals.f32test.ui.screens.main.categories.CategoriesSelector
import app.seals.f32test.ui.screens.main.search.SearchField

@Composable
fun MainScreen(vm: MainActivityViewModel) {
    Column {
        CategoriesSelector(vm)
        SearchField()
    }
}