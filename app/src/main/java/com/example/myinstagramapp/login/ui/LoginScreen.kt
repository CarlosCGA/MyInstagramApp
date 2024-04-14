package com.example.myinstagramapp.login.ui

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myinstagramapp.R

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(
            Modifier
                .align(Alignment.Center)
                .padding(horizontal = 8.dp),
            loginViewModel
        )
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(LoginViewModel())
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
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email by loginViewModel.email.observeAsState(initial = "")

    val password by loginViewModel.password.observeAsState(initial = "")

    val isLogInEnabled by loginViewModel.isLogInEnabled.observeAsState(initial = false)

    Column(modifier = modifier) {
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.insta),
            contentDescription = "Instagram"
        )

        Spacer(modifier = Modifier.size(30.dp))

        Email(email) { newEmail ->
            loginViewModel.onLogInChanged(newEmail, password)
        }

        Spacer(modifier = Modifier.size(8.dp))

        Password(
            password = password,
            onValueChange = { newPassword ->
                loginViewModel.onLogInChanged(email, newPassword)
            })

        Spacer(modifier = Modifier.size(12.dp))

        ForgotPassword(modifier = Modifier.align(Alignment.End))

        Spacer(modifier = Modifier.size(24.dp))

        LogInButton(isLogInEnabled)

        Spacer(modifier = Modifier.size(16.dp))

        LogInDivider()

        Spacer(modifier = Modifier.size(30.dp))

        SocialLogIn(modifier = Modifier.align(Alignment.CenterHorizontally))
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
        onValueChange = { newItem -> onValueChange.invoke(newItem) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun Password(password: String, onValueChange: (String) -> Unit) {
    var showPassword by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = colorResource(id = R.color.bright_blue),
            unfocusedLabelColor = Color.Gray,
            focusedContainerColor = Color.White,
        ),
        trailingIcon = {
            val image =
                if (showPassword)
                    Icons.Filled.Visibility
                else
                    Icons.Filled.VisibilityOff
            Icon(
                imageVector = image,
                contentDescription = "Toggle password visibility",
                Modifier.clickable {
                    showPassword = !showPassword
                }
            )
        },
        value = password,
        label = { Text(text = "Password") },
        onValueChange = { newPassword -> onValueChange.invoke(newPassword) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation =
        if (showPassword)
            VisualTransformation.None
        else
            PasswordVisualTransformation()

    )
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        modifier = modifier
            .clickable { },
        text = "Forgot password?",
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = Color(0xFF4EA8E9)
    )
}

@Composable
fun LogInButton(logInEnabled: Boolean) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {},
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color(0xFF4EA8E9),
            disabledContentColor = Color.White,
            disabledContainerColor = Color(0xFF78C8F9)
        ),
        enabled = logInEnabled
    ) {
        Text(text = "Log In")
    }
}

@Composable
fun LogInDivider() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
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
}

@Composable
fun SocialLogIn(modifier: Modifier) {
    Row(
        modifier = modifier
            .height(20.dp)
            .clickable { },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.fb), contentDescription = "Facebook")
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = "Continue as Dave Johnson",
            color = Color(0xFF4EA8E9),
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier) {
        Divider(modifier = Modifier.padding(horizontal = 4.dp))

        Spacer(modifier = Modifier.size(32.dp))

        SignUp(modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.size(16.dp))

    }
}

@Composable
fun SignUp(modifier: Modifier) {
    Row(
        modifier = modifier,
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
            color = Color(0xFF4EA8E9)
        )
    }
}
