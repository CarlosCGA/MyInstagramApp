package com.example.myinstagramapp.login.data.network

import com.example.myinstagramapp.login.data.network.response.LogInResponse
import retrofit2.Response
import retrofit2.http.GET

//Interfaz donde se acumulan las llamadas a los endpoints que tienen que ver
interface LogInClient {
    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
    suspend fun doLogIn(user: String, password: String): Response<LogInResponse>
}