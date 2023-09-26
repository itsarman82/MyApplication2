package com.arman.myapplication.MainScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


const val mainScreenRoute = "mainscreen_route"

fun NavHostController.navigateToMainScreen() {
 this.navigate(mainScreenRoute){
     popUpTo(0)
     launchSingleTop = true
 }
}

fun NavGraphBuilder.mainScreen() {
    composable(mainScreenRoute) {
        MainScreenRoute()
    }
}