package com.arman.myapplication.resources


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = grey,
    onPrimary = white,
    secondary = grey,
    tertiary = blue,
    background = white,
    surface = white
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