package com.arman.myapplication.application

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.arman.myapplication.ui.Account.accountScreen
import com.arman.myapplication.ui.MainScreen.mainScreen
import com.arman.myapplication.ui.MainScreen.mainScreenRoute
import com.arman.myapplication.ui.MainScreen.navigateToMainScreen
import com.arman.myapplication.ui.Signin.navigateToSignin
import com.arman.myapplication.ui.Signin.signinScreen
import com.arman.myapplication.ui.login.loginNavigationRoute
import com.arman.myapplication.ui.login.loginScreen
import com.arman.myapplication.ui.login.navigateToLogin

@Composable
fun ApplicationNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = mainScreenRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier
    ){
        loginScreen(onClickSignIn = navController::navigateToSignin, onClickLogin = navController::navigateToMainScreen)
        signinScreen(onClickSignin = navController::navigateToLogin)
        accountScreen()
        mainScreen()
    }
}