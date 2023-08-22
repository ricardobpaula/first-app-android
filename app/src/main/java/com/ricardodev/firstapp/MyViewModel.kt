package com.ricardodev.firstapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val users: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

}