package com.example.ordereasy.ui.foodMenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodMenuViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Menú Fragment"
    }
    val text: LiveData<String> = _text
}