package app.seals.f32test.ui.main.vm

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.lifecycle.viewModelScope
import app.seals.f32test.ui.sampledata.DataPump
import kotlinx.coroutines.launch

open class MainActivityViewModel : BaseViewModel() {

    override var listStateStorage: LazyListState = LazyListState(0)

    open fun getData() {
        viewModelScope.launch {
            state.emit(DataPump.state)
        }
    }

    fun goMain() {
        viewModelScope.launch {
            state.emit(DataPump.state)
        }
    }

    fun goDetails() {
        viewModelScope.launch {
            state.emit(DataPump.stateDetails)
        }
    }
}