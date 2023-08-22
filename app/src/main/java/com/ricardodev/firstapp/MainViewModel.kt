package com.ricardodev.firstapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val uiState: MutableLiveData<UIState> by lazy {
        MutableLiveData<UIState>()
    }

    init { uiState.postValue(UIState())}

    fun updateName(newName: String) {
        uiState.postValue(
            uiState.value?.copy(
                currentName = newName
            )
        )
    }

    fun onTextChanged() = uiState.value?.copy(isLoading = false)
    fun onButtonClick()  = uiState.value?.copy(isLoading = true)

    data class UIState   (
        val currentName: String = "",
        val isLoading: Boolean = false
    )
}