package com.example.myinstagramapp.login.data

import com.example.myinstagramapp.login.data.network.LogInService
import javax.inject.Inject

//Encargado de gestionar de donde obtener los datos correspondientes a las llamadas y devolverlos
//a las llamadas del dominio
class LogInRepository @Inject constructor(private val api: LogInService) {
    //private val api = LogInService() UPGRADE WITH DAGGER HILT INJECT CONSTRUCTOR

    suspend fun doLogIn(user: String, password: String): Boolean {
        return api.doLogIn(user, password)
    }
}