package app.seals.f32test.ui.states

sealed interface UiState {
    object IsLoading : UiState
    data class IsReady(val items: List<*>, val selected: String) : UiState
    data class HasError(val code: Int?, val message: String?) : UiState
    data class HasException(val e: Throwable?) : UiState
}
