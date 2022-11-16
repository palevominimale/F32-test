package app.seals.f32test.ui.states

import app.seals.f32test.entities.DetailsModel
import app.seals.f32test.entities.base.BaseResponse
import app.seals.f32test.entities.cart.CartResponse
import app.seals.f32test.ui.screens.CategoryItemModel

sealed interface UiState {
    object IsLoading : UiState
    data class MainReady(
        val categories: List<CategoryItemModel>,
        val apiResponse: BaseResponse? = null,
        val selectedItem: Int = -1
    ) : UiState
    data class DetailsReady(val item: DetailsModel) : UiState
    data class CartReady(val cart: CartResponse) : UiState
}
