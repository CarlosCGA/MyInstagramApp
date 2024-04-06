package com.example.myinstagramapp

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Content(
            Modifier
                .align(Alignment.Center)
                .padding(horizontal = 8.dp)
        )
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        modifier = modifier.clickable { activity.finish() },
        imageVector = Icons.Default.Close,
        contentDescription = "close app",
    )
}

@Composable
fun Content(modifier: Modifier) {
    var itemLogIn by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.insta),
            contentDescription = "Instagram"
        )

        Spacer(modifier = Modifier.size(30.dp))
        Email(itemLogIn) { newItem -> itemLogIn = newItem }
        Spacer(modifier = Modifier.size(8.dp))
        Password(password = password) { newItem -> password = newItem }


        Text(
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 12.dp)
                .clickable { },
            text = "Forgot password?",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color(0xFF4EA8E9)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {},
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = colorResource(id = R.color.bright_blue),
                disabledContentColor = Color.White,
                disabledContainerColor = colorResource(id = R.color.baby_blue)
            )
        ) {
            Text(text = "Log In")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f),
                color = Color.LightGray
            )
            Text(
                text = "OR",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
            Divider(
                modifier = Modifier
                    .weight(1f),
                color = Color.LightGray
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp)
                .height(20.dp)
                .clickable { },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.fb), contentDescription = "Facebook")
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "Continue as Dave Johnson",
                color = colorResource(id = R.color.bright_blue),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun Email(itemLogIn: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = colorResource(id = R.color.bright_blue),
            unfocusedLabelColor = Color.Gray,
            focusedContainerColor = Color.White
        ),
        value = itemLogIn,
        label = {
            Text(
                text = "Phone number, username or email"
            )
        },
        onValueChange = { onValueChange.invoke(itemLogIn) },
        singleLine = true
    )
}

@Composable
fun Password(password: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = colorResource(id = R.color.bright_blue),
            unfocusedLabelColor = Color.Gray,
            focusedContainerColor = Color.White,
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Toggle password",
                Modifier.clickable {

                }
            )
        },
        value = password,
        label = { Text(text = "Password") },
        onValueChange = { onValueChange.invoke(password) },
        singleLine = true
    )
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier) {
        Divider(modifier = Modifier.padding(horizontal = 4.dp))

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 14.sp,
            )

            Text(
                modifier = Modifier
                    .padding(start = 2.dp)
                    .clickable { },
                text = "Sign Up.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.bright_blue)
            )
        }
    }
}