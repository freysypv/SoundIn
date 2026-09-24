package com.example.soundin.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    // Private state -- only this class can modify (write) it
    private val _email = MutableStateFlow(value = "")
    private val _password = MutableStateFlow(value = "")
    private val _rememberSession = MutableStateFlow(value = false)
    private val _emailError = MutableStateFlow(value = false)
    private val _passwordError = MutableStateFlow(value = false)

    // Public state -- anyone can read, the UI can observe
    val email: StateFlow<String> = _email.asStateFlow()
    val password: StateFlow<String> = _password.asStateFlow()
    val rememberSession: StateFlow<Boolean> = _rememberSession.asStateFlow()
    val emailError: StateFlow<Boolean> = _emailError.asStateFlow()
    val passwordError: StateFlow<Boolean> = _passwordError.asStateFlow()

    // Update functions -- the only way to modify the state
    fun onEmailChange(value: String) {
        _email.value = value
        _emailError.value = false
    }

    fun onPasswordChange(value: String) {
        _password.value = value
        _passwordError.value = false
    }

    fun onRememberSessionChange(value: Boolean) {
        _rememberSession.value = value
    }

    // Validation -- called from the UI when the user submits the form (taps Login)
    fun validateAndLogin(): Boolean {
        val isEmailValid = _email.value.contains(other = "@") && _email.value.contains(other = ".")
        val isPasswordValid = _password.value.length >= 6
        _emailError.value = !isEmailValid
        _passwordError.value = !isPasswordValid
        return isEmailValid && isPasswordValid
    }
}