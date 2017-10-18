package com.unicorn.mediatorex

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class SimpleViewModel : ViewModel() {
    var status = MutableLiveData<String>()
}

