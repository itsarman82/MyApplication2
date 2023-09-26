package com.arman.myapplication.Signin

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SigninRoute(viewModel: SigninViewModel = hiltViewModel()) {
    SigninScreen(onClickLogin = {
        viewModel.signin()
    }) {}
}