package com.example.myinstagramapp.login.data.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//Encargado de llamar a todos los endpoints del LogInClient y poseera el objecto Retrofit
//
class LogInService @Inject constructor(private val logInClient: LogInClient) {
    //private val retrofit = RetrofitHelper.getRetrofit() UPGRADE WITH DAGGER HILT INJECT CONSTRUCTOR

    suspend fun doLogIn(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = logInClient.doLogIn(/*user, password*/)
            Log.d("CARLOS", "RESPONSE -> ${response.body()}")
            response.body()?.success ?: false//If null return false
        }
    }
}