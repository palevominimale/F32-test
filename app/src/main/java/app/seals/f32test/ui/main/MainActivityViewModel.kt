package app.seals.f32test.ui.main

import androidx.lifecycle.viewModelScope
import app.seals.f32test.ui.sampledata.DataPump
import kotlinx.coroutines.launch

open class MainActivityViewModel : BaseViewModel() {

    open fun getData() {
        viewModelScope.launch {
            state.emit(DataPump.state)
        }
    }

}