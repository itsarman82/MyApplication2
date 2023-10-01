package com.arman.myapplication.ui.Signin

import java.io.Serializable

sealed interface SignInUiState : Serializable {
    object Content : SignInUiState
    object Loading : SignInUiState
    data class Successful(val message: String) : SignInUiState
    data class Error(val message: String) : SignInUiState
}