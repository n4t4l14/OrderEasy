package com.example.ordereasy.ui.myShopping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyShoppingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is myShopping Fragment"
    }
    val text: LiveData<String> = _text
}