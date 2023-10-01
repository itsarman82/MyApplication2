package com.arman.myapplication.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.arman.myapplication.Signin.SigninUIStateUIState

@Composable
fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel(),
    onClickSignIn: () -> Unit,
    onClickLogin: () -> Unit
) {
    val phoneValue by viewModel.phone.collectAsState()
    val passwordValue by viewModel.password.collectAsState()
    val isLogin by viewModel.checkDataStore.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    if (isLogin) {
        onClickLogin()
    } else {
        LoginScreen(
            phoneValue = phoneValue,
            passwordValue = passwordValue,
            onChangePhone = viewModel::onChangePhone,
            onChangePassword = viewModel::onChangePassword,
            onClickLogin = viewModel::validateUser,
            onClickSignIn = onClickSignIn
        )
    }

    if (uiState is LoginUIState.Error) {
        var showDialog by remember {
            mutableStateOf(true)
        }
        if (showDialog) {
            Dialog(
                onDismissRequest = { showDialog = false },
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp),
                        text = (uiState as LoginUIState.Error).message,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TextButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        onClick = { showDialog = false },
                    ) {
                        Text(
                            text = "فهمیدم",
                        )
                    }
                }
            }

        } else {
            viewModel.onChangeUiState(LoginUIState.Content)
        }
    }
    if (uiState is LoginUIState.Success) {
        onClickLogin()
    }
}