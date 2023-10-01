package com.arman.myapplication.ui.MainScreen

import java.io.Serializable

sealed interface MainScreenUIState : Serializable {
    object Loading : MainScreenUIState
    object Content : MainScreenUIState
    data class Error(var message: String) : MainScreenUIState
    object Sucssessful : MainScreenUIState
}