package com.example.ordereasy.ui.foodMenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodMenuViewModel : ViewModel() {

    // LiveData para almacenar el texto que se mostrará en la UI
    private val _text = MutableLiveData<String>().apply {
        value = "Este es el Fragmento de Menú"
    }

    // LiveData público que expondrá el texto a la UI
    val text: LiveData<String> = _text
}
