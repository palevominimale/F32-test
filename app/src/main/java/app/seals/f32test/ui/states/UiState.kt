package app.seals.f32test.ui.states

import app.seals.f32test.ui.models.BestSellerItemModel
import app.seals.f32test.ui.models.CategoryItemModel
import app.seals.f32test.ui.models.hotsales.HomeStoreItemModel

sealed interface UiState {
    object IsLoading : UiState
    data class IsReady(
        val categories: List<CategoryItemModel>,
        val selectedCategory: String,
        val hotSales: List<HomeStoreItemModel>,
        val bestSeller: List<BestSellerItemModel>,
        val showFilter: Boolean = true,
        val selectedItem: Int = -1
    ) : UiState
    data class HasError(val code: Int?, val message: String?) : UiState
    data class HasException(val e: Throwable?) : UiState
}
