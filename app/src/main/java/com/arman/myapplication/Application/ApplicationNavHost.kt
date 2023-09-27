package com.arman.myapplication.Application

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.arman.myapplication.MainScreen.mainScreen
import com.arman.myapplication.MainScreen.navigateToMainScreen
import com.arman.myapplication.Signin.navigateToSignin
import com.arman.myapplication.Signin.signinScreen
import com.arman.myapplication.login.LoginScreen
import com.arman.myapplication.login.loginNavigationRoute
import com.arman.myapplication.login.loginScreen
import com.arman.myapplication.login.navigateToLogin

@Composable
fun ApplicationNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = loginNavigationRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier
    ){
        loginScreen(onClickSignIn = navController::navigateToSignin, onClickLogin = navController::navigateToMainScreen)
        signinScreen(onClickSignin = navController::navigateToSignin)
        mainScreen()
    }
}