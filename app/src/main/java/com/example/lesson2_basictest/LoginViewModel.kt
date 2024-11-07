package com.example.lesson2_basictest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// LoginViewModel.kt remains the same
class LoginViewModel : ViewModel() {

    private var username: String = ""
    private var password: String = ""

    val loginResult = MutableLiveData<Boolean>()

    fun setUsername(username: String) {
        this.username = username
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun login(): Boolean {
        if (username == "user" && password == "password") {
            loginResult.value = true
            return true
        } else {
            loginResult.value = false
            return false
        }
    }
}