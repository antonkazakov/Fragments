package otus.gpb.homework.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentsViewModel : ViewModel() {

    private val _stateColor = MutableLiveData<Int>()
    val stateColor: LiveData<Int> get() = _stateColor

    fun passNewColor(someColor: Int) {
        _stateColor.value = someColor
    }
}