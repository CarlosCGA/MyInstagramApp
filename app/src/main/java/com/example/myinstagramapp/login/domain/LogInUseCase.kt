package com.example.myinstagramapp.login.domain

import com.example.myinstagramapp.login.data.LogInRepository


class LogInUseCase {
    private val repository = LogInRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogIn(user, password)
    }
}