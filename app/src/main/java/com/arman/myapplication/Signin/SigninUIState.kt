package com.arman.myapplication.Signin

import java.io.Serializable

sealed interface SigninUIStateUIState : Serializable {
    object Loading : SigninUIStateUIState
    data class Successful(val message: String) : SigninUIStateUIState
    data class Error(val message: String) : SigninUIStateUIState
}