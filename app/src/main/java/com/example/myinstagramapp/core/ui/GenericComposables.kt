package com.example.myinstagramapp.core.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myinstagramapp.R

@Composable
fun ImageInstagram(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Instagram"
    )
}

@Composable
fun ImageFacebook(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.fb),
        contentDescription = "Facebook"
    )
}