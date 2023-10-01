package com.arman.myapplication.Signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.arman.myapplication.login.LoginUIState

@Composable
fun SigninRoute(
    viewModel: SigninViewModel = hiltViewModel(),
    onClickSignin: () -> Unit,
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
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp),
                        text = (uiState as SigninUIStateUIState.Error).message,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onPrimary
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
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        } else {
            viewModel.onChangeUiState(SigninUIStateUIState.Content)
        }
    }

    if (uiState is SigninUIStateUIState.Successful) {
        onClickSignin()
    }
}