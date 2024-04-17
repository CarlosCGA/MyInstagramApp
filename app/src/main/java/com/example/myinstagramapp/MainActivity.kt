package com.example.myinstagramapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.myinstagramapp.login.ui.LogInScreen
import com.example.myinstagramapp.login.ui.LoginViewModel
import com.example.myinstagramapp.ui.theme.MyInstagramAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //DAGGER HILT DECLARATION
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyInstagramAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LogInScreen(loginViewModel)
                }
            }
        }
    }
}