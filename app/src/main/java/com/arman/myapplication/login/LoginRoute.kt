package com.arman.myapplication.login

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel(),
    onClickSignIn:()->Unit,
    onClickLogin:()->Unit
    ) {
    val phoneValue by viewModel.phone.collectAsState()
    val passwordValue by viewModel.password.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    LoginScreen(
        phoneValue = phoneValue,
        passwordValue = passwordValue,
        onChangePhone = viewModel::onChangePhone,
        onChangePassword = viewModel::onChangePassword,
        onClickLogin = viewModel::validateUser,
        onClickSignIn = onClickSignIn
    )
    
    if(uiState is LoginUIState.Error) {
        Dialog(onDismissRequest = { /*TODO*/ }) {
            Card {
                Text(text = (uiState as LoginUIState.Error).message)
            }
            
        }
    }
    
    if (uiState is LoginUIState.Success) {
        onClickLogin()
    }
}