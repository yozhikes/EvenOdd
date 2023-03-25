package com.example.cheanichebymidili

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel:ViewModel() {
    val otvForUserFragment:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val otvForComputerFragment:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}