package com.arman.myapplication.resources


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    surface = white,
    background = white,
    primary = grey,
    onPrimary = white,
    onPrimaryContainer = white,
    secondary = grey,
    tertiary = blue,

)

@Composable
fun LoginPageTheme(
    content: @Composable () -> Unit
) {


    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}