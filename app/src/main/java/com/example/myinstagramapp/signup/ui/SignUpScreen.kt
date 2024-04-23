package com.example.myinstagramapp.signup.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myinstagramapp.core.ui.ImageFacebook
import com.example.myinstagramapp.core.ui.ImageInstagram

@Preview
@Composable
fun SignUpScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            ImageInstagram(modifier = Modifier.align(Alignment.CenterHorizontally))
            Title()
            Spacer(modifier = Modifier.size(8.dp))
            SocialLogInButton()
        }
    }
}

@Composable
fun Title() {
    Text(text = "Sign up to see photos and videos from your friends.", fontWeight = FontWeight.Bold)
}

@Composable
fun SocialLogInButton() {
    Button(
        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(

        )
    ) {
        Row {
            ImageFacebook(modifier = Modifier)
            Text(text = "Log in with Facebook")
        }

    }
}