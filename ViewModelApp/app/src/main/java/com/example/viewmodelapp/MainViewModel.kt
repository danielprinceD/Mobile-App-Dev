package com.example.viewmodelapp

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var count = 0
    public fun increement() : Unit{
        count++
    }
    public fun get() : String{
        return count.toString()
    }
}