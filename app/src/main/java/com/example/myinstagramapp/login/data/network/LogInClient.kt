package com.example.myinstagramapp.login.data.network

import com.example.myinstagramapp.login.data.network.response.LogInResponse
import retrofit2.Response
import retrofit2.http.GET

//Interfaz donde se acumulan las llamadas a los endpoints que tienen que ver
interface LogInClient {
    @GET("v3/91c3c405-a8ac-4f6b-b1f3-f3306aa3efd1")
    suspend fun doLogIn(/*TODO user: String, password: String*/): Response<LogInResponse>
}