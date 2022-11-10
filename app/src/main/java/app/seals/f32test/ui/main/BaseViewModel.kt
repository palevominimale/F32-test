package app.seals.f32test.ui.main

import androidx.lifecycle.ViewModel
import app.seals.f32test.ui.states.UiState
import app.seals.f32test.ui.states.UiState.IsLoading
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel : ViewModel() {
    private val _state = MutableStateFlow<UiState>(IsLoading)
    open val state get() = _state
}