package com.arman.myapplication.login

import java.io.Serializable

sealed interface LoginUIState : Serializable {
    object Loading : LoginUIState
    object Success : LoginUIState
    data class Error(val message: String) : LoginUIState
}