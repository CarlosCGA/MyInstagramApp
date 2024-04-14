package com.example.myinstagramapp.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLogInEnabled = MutableLiveData<Boolean>()
    val isLogInEnabled: LiveData<Boolean> = _isLogInEnabled

    fun onLogInChanged(email: String, password: String) {
        _email.value = email
        _password.value = password

        enableLogIn(email, password)
    }

    private fun enableLogIn(email: String, password: String) {
         _isLogInEnabled.value = Patterns.EMAIL_ADDRESS.matcher(email)
            .matches() && password.isNotBlank() && password.length > 6
    }
}