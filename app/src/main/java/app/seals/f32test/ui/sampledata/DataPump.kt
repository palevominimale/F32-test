package app.seals.f32test.ui.sampledata

import android.annotation.SuppressLint
import app.seals.f32test.R
import app.seals.f32test.ui.main.MainActivityViewModel
import app.seals.f32test.ui.models.categories.CategoryItemModel
import app.seals.f32test.ui.states.UiState
import kotlinx.coroutines.flow.MutableStateFlow

object DataPump {
    private val listOfCategories = listOf(
        CategoryItemModel("Phones", R.drawable.ic_outline_phone_iphone_24, selected = true),
        CategoryItemModel("Computer", R.drawable.ic_baseline_computer_24, selected = false),
        CategoryItemModel("Health", R.drawable.ic_baseline_health_and_safety_24, selected = false),
        CategoryItemModel("Books", R.drawable.ic_baseline_library_books_24, selected = false),
        CategoryItemModel("Hearts", R.drawable.ic_baseline_favorite_border_24, selected = false),
        CategoryItemModel("Phones1", R.drawable.ic_outline_phone_iphone_24, selected = false),
        CategoryItemModel("Computer1", R.drawable.ic_baseline_computer_24, selected = false),
        CategoryItemModel("Health1", R.drawable.ic_baseline_health_and_safety_24, selected = false),
        CategoryItemModel("Books1", R.drawable.ic_baseline_library_books_24, selected = false),
        CategoryItemModel("Hearts1", R.drawable.ic_baseline_favorite_border_24, selected = false),
    )

    val state = UiState.IsReady(
        items = listOfCategories,
        selected = listOfCategories[0].title ?: ""
    )

    val vm = @SuppressLint("StaticFieldLeak")
    object : MainActivityViewModel() {
        override val state = MutableStateFlow<UiState>(this@DataPump.state)
    }
}