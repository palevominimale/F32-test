package app.seals.f32test.main.vm

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.viewModelScope
import app.seals.f32test.R
import app.seals.f32test.domain.usecase.GetBaseDataUseCase
import app.seals.f32test.domain.usecase.GetCartUseCase
import app.seals.f32test.domain.usecase.GetSelectedDetailsUseCase
import app.seals.f32test.entities.DetailsModel
import app.seals.f32test.entities.api.ApiResult
import app.seals.f32test.entities.base.BaseResponse
import app.seals.f32test.entities.cart.CartResponse
import app.seals.f32test.ui.screens.CategoryItemModel
import app.seals.f32test.ui.states.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

open class MainActivityViewModel(
    private val getBase: GetBaseDataUseCase,
    private val getDetails: GetSelectedDetailsUseCase,
    private val getCart: GetCartUseCase
) : BaseViewModel() {

    override var listStateStorage: LazyListState = LazyListState(0)
    private val _response = MutableStateFlow<ApiResult>(ApiResult.ApiError())
    private val scope = CoroutineScope(Dispatchers.IO)

    private val listOfCategories = listOf(
        CategoryItemModel("Phones", R.drawable.ic_outline_phone_iphone_24, selected = true),
        CategoryItemModel("Computer", R.drawable.ic_baseline_computer_24, selected = false),
        CategoryItemModel("Health", R.drawable.ic_baseline_health_and_safety_24, selected = false),
        CategoryItemModel("Books", R.drawable.ic_baseline_library_books_24, selected = false),
        CategoryItemModel("Hearts", R.drawable.ic_baseline_favorite_border_24, selected = false),
        CategoryItemModel("Hearts", R.drawable.ic_baseline_favorite_border_24, selected = false),
    )

    init {
        viewModelScope.launch {
            _response.collectLatest {
                when(it) {
                    is ApiResult.ApiError -> {
                        Log.e("MAVM_api_err", "$it")
                        state.emit(UiState.Error(it.code, it.message))
                    }
                    is ApiResult.ApiException -> {
                        Log.e("MAVM_api_exc", "$it")
                        state.emit(UiState.Exception(it.e))
                    }
                    is ApiResult.ApiSuccess -> {
                        Log.e("MAVM_api_scs", "$it")
                        when(it.data) {
                            is DetailsModel -> {
                                state.emit(UiState.DetailsReady(it.data as DetailsModel))
                                Log.e("MAVM_state", "${it.data}")
                            }
                            is CartResponse -> {
                                state.emit(UiState.CartReady(it.data as CartResponse))
                                Log.e("MAVM_state", "${it.data}")
                            }
                            is BaseResponse -> {
                                state.emit(UiState.MainReady(
                                apiResponse = it.data as BaseResponse,
                                categories = listOfCategories)
                                )
                                Log.e("MAVM_state", "${it.data}")
                            }
                        }
                    }
                }
            }
        }
    }

    open fun getData() {
        scope.launch {
            state.emit(UiState.IsLoading)
            _response.emit(getBase.execute())
        }
    }

    fun goMain() {
        scope.launch {
            _response.emit(getBase.execute())
        }
    }

    fun goDetails() {
        scope.launch {
            _response.emit(getDetails.execute(0))
        }
    }

    fun goCart() {
        scope.launch {
            _response.emit(getCart.execute())
        }
    }
}