package com.example.myinstagramapp.login.domain

import com.example.myinstagramapp.login.data.LogInRepository
import javax.inject.Inject


class LogInUseCase @Inject constructor(private val repository: LogInRepository) {
    //private val repository = LogInRepository() UPGRADE WITH DAGGER HILT INJECT CONSTRUCTOR

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogIn(user, password)
    }
}