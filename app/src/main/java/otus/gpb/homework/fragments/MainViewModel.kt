package otus.gpb.homework.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _isShow = MutableLiveData(true)
    var isShow: LiveData<Boolean> = _isShow

    fun mainIsShow(boolean: Boolean) {
        _isShow.value = boolean
        isShow = _isShow
    }
}
