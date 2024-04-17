package com.example.myinstagramapp.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myinstagramapp.login.domain.LogInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel //DAGGER HILT DECLARATION
class LoginViewModel @Inject constructor(private val logInUseCase: LogInUseCase) : ViewModel() {

    //val logInUseCase = LogInUseCase() UPGRADE WITH DAGGER HILT INJECT CONSTRUCTOR

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

    fun onLogInSelected() {
        viewModelScope.launch {
            val result = logInUseCase(email.value!!, password.value!!)

            if (result) {
                Log.i("CARLOS", "GO IN!")
            }
        }
    }
}