package com.arman.myapplication.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arman.myapplication.Signin.SigninUIStateUIState
import com.arman.myapplication.data.UserRepository
import com.arman.myapplication.datastore.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userRepository: UserRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    val checkDataStore = savedStateHandle.getStateFlow(CHECK, false)
    val phone = savedStateHandle.getStateFlow(PHONE, "")
    val password = savedStateHandle.getStateFlow(PASSWORD, "")
    val uiState: StateFlow<LoginUIState> =
        savedStateHandle.getStateFlow(STATE, LoginUIState.Loading)

    init {
        checkDataStore()
    }
    fun onChangeUiState(uiState: LoginUIState) {
        savedStateHandle[STATE] = uiState
    }

    fun onChangePhone(phone: String) {
        savedStateHandle[PHONE] = phone
    }

    fun onChangePassword(password: String) {
        savedStateHandle[PASSWORD] = password
    }

    fun checkDataStore() = viewModelScope.launch {
        savedStateHandle[CHECK] = dataStoreManager.getLoginStatus().first()
    }

    fun validateUser() = viewModelScope.launch {
        if (phone.value.isNotEmpty()) {
            if (password.value.isNotEmpty()) {
                val users = userRepository.validateUser(phone.value, password.value)
                if (users.isNotEmpty()) {
                    savedStateHandle[STATE] = LoginUIState.Success
                    dataStoreManager.saveLoginStatus(true)
                } else {
                    savedStateHandle[STATE] =
                        LoginUIState.Error("تلفن همراه یا رمز عبور نا معتبر است")
                }
            } else {
                savedStateHandle[STATE] = LoginUIState.Error("لطفا رمز عبور خود را وارد کنید")
            }
        } else {
            savedStateHandle[STATE] = LoginUIState.Error("لطفا شماره تلفن خود را وارد کنید")
        }
    }

}

private const val PHONE = "phone"
private const val PASSWORD = "password"
private const val STATE = "state"
private const val CHECK = "check"