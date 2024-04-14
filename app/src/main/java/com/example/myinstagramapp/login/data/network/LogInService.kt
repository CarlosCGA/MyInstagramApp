package com.example.myinstagramapp.login.data.network

import android.util.Log
import com.example.myinstagramapp.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//Encargado de llamar a todos los endpoints del LogInClient y poseera el objecto Retrofit
//
class LogInService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogIn(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LogInClient::class.java).doLogIn(/*user, password*/)
            Log.d("CARLOS", "RESPONSE -> ${response.body()}")
            response.body()?.success ?: false//If null return false
        }
    }
}