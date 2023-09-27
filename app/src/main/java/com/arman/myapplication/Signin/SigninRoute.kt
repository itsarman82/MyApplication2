package com.arman.myapplication.Signin

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SigninRoute(
    viewModel: SigninViewModel = hiltViewModel(),
    onClickSignin: () -> Unit
    ) {

    val fullnameValue by viewModel.fullName.collectAsState()
    val phoneValue by viewModel.phone.collectAsState()
    val passwordValue by viewModel.password.collectAsState()
    val passwordonconfirmValue by viewModel.passwordonconfirm.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    SigninScreen(
        fullname = fullnameValue,
        phone = phoneValue,
        password = passwordValue,
        passwordonconfirm = passwordonconfirmValue,
        onChangeFullname = viewModel::onChangeFullname,
        onChangePhone = viewModel::onChangePhone,
        onChangePassword = viewModel::onChangePassword,
        OnChangePasswordonconfirm = viewModel::OnChangePasswordonconfirm,
        onClickSignIn = viewModel::addUser
    )

    if (uiState is SigninUIStateUIState.Error) {
        Dialog(onDismissRequest = { /*TODO*/ }) {
            Card {
                Text(text = (uiState as SigninUIStateUIState.Error).message)
            }
        }
    }

    if (uiState is SigninUIStateUIState.Successful) {
        onClickSignin()
    }
}