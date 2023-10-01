package com.arman.myapplication.ui.Account

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

const val accountScreenRoute = "accountScreenRoute"

fun NavHostController.navigateToAccountScreen() {
    this.navigate(accountScreenRoute){
        popUpTo(0)
        launchSingleTop = true
    }
}

fun NavGraphBuilder.accountScreen() {
    composable(accountScreenRoute) {
        AccountScreen()
    }
}