package com.arman.myapplication.ui.Signin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

const val signinNavigationRoute = "signin_route"

fun NavHostController.navigateToSignin() {
    this.navigate(signinNavigationRoute) {
        launchSingleTop = true
    }
}


fun NavGraphBuilder.signinScreen(onClickSignin: () -> Unit) {
    composable(signinNavigationRoute) {
        SigninRoute(onClickSignin = { onClickSignin() })
    }
}