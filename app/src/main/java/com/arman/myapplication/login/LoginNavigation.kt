package com.arman.myapplication.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

const val loginNavigationRoute = "login_route"

fun NavHostController.navigateToLogin() {

}


fun NavGraphBuilder.loginScreen(onClickSignIn:()->Unit, onClickLogin: () -> Unit) {
    composable(loginNavigationRoute) {
        LoginRoute(onClickSignIn = onClickSignIn, onClickLogin = onClickLogin)
    }
}