package com.example.viewmodelapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var count = MutableLiveData<Int>()
    init{ count.value = 0 }
    public fun increement() : Unit{
        count.value = count.value?.plus(1)
    }

    public fun get() : MutableLiveData<Int>{
        return count
    }
}