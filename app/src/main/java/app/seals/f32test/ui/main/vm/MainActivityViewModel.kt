package app.seals.f32test.ui.main.vm

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.seals.f32test.ui.sampledata.DataPump
import kotlinx.coroutines.launch

open class MainActivityViewModel : BaseViewModel() {

    open fun getData() {
        viewModelScope.launch {
            state.emit(DataPump.state)
        }
    }

    fun select(id: Int) {
        Log.e("MAVM_", "selected $id")
        viewModelScope.launch {
            state.emit(DataPump.stateDetails)
        }
    }
}