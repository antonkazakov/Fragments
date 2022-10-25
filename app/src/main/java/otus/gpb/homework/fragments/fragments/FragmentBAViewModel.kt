package otus.gpb.homework.fragments.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentBAViewModel : ViewModel() {
    private val _color = MutableLiveData<Int>()
    var color: LiveData<Int> = _color

    fun getColor(color: Int) {
        _color.value = color
        this.color = _color
    }
}
