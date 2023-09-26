package com.arman.myapplication.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arman.myapplication.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle, private val userRepository: UserRepository) : ViewModel() {

    val phone = savedStateHandle.getStateFlow(PHONE,"")
    val password = savedStateHandle.getStateFlow(PASSWORD,"")
    val uiState:StateFlow<LoginUIState> = savedStateHandle.getStateFlow(STATE,LoginUIState.Loading)

    fun onChangePhone(phone:String){
        savedStateHandle[PHONE] = phone
    }
    fun onChangePassword(password:String){
        savedStateHandle[PASSWORD] = password
    }

    fun validateUser() = viewModelScope.launch {
        val users = userRepository.validateUser(phone.value, password.value)
        if (users.isEmpty()) {
            savedStateHandle[STATE] = LoginUIState.Error("نام کاربری یا رمز عبور صحسح نمیباشد.")
        }else {
            savedStateHandle[STATE] = LoginUIState.Success
        }
    }

}

private const val PHONE = "phone"
private const val PASSWORD = "password"
private const val STATE = "state"