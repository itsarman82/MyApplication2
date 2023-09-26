package com.arman.myapplication

sealed interface MainUIState {
    object UnAuthorized
    object Authorized
    object SignIn
}