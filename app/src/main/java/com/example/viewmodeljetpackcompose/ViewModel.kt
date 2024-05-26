package com.example.viewmodeljetpackcompose

import android.view.View
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModel(
    number: Int
): ViewModel() {
    private val _text = MutableStateFlow("")
    val text = _text.asStateFlow()

    fun changeText(newText: String) {
        _text.value = newText
    }
}