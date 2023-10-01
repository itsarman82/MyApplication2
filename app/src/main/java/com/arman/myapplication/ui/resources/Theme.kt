package com.arman.myapplication.ui.resources


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorScheme = lightColorScheme(
    surface = white,
    primary = grey,
    onPrimary = white,
    onPrimaryContainer = white,
    secondary = white,
    onSecondary = white,
    tertiary = blue,
)

@Composable
fun LoginPageTheme(
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = LightColorScheme.surface,
        darkIcons = true
    )

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}