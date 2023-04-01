package com.example.cheanichebymidili

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel:ViewModel() {
    val otvForUserFragment:MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val startCheck:MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
}