package com.example.soundin.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserSessionViewModel : ViewModel() {
    // Challenge
    // private state -- mutable properties
    private val _userName = MutableStateFlow("")
    private val _userEmail = MutableStateFlow("")
    private val _isLoggedIn = MutableStateFlow(false)


    // challenge
    // public state -- exposed as immutable properties as StateFlow to the UI
    val userName: StateFlow<String> = _userName.asStateFlow()
    val userEmail: StateFlow<String> = _userEmail.asStateFlow()
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    fun login(name: String, email: String) {
        // set the updated property values
        _userName.value = name
        _userEmail.value = email
        _isLoggedIn.value = true
    }

    // called when the user log out
    fun logout() {
        _userName.value = ""
        _userEmail.value = ""
        _isLoggedIn.value = false // set last -- clear data before ui reacts to it
    }
}