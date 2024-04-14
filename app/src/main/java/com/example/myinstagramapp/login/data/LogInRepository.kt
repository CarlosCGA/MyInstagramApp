package com.example.myinstagramapp.login.data

import com.example.myinstagramapp.login.data.network.LogInService

//Encargado de gestionar de donde obtener los datos correspondientes a las llamadas y devolverlos
//a las llamadas del dominio
class LogInRepository {
    private val api = LogInService()

    suspend fun doLogIn(user: String, password: String): Boolean {
        return api.doLogIn(user, password)
    }
}