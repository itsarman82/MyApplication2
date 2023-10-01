package com.arman.myapplication.ui.Signin

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arman.myapplication.database.User
import com.arman.myapplication.database.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SigninViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userRepository: UserRepository,
) : ViewModel() {
    val fullName = savedStateHandle.getStateFlow(FULLNAME, "")
    val phone = savedStateHandle.getStateFlow(PHONE,"")
    val password = savedStateHandle.getStateFlow(PASSWORD, "")
    val passwordonconfirm = savedStateHandle.getStateFlow(PASSWORDONCONFIRM,"")
    val uiState:StateFlow<SignInUiState> = savedStateHandle.getStateFlow(
        STATE,
        SignInUiState.Content
    )

    fun onChangeUiState(uiState: SignInUiState) {
        savedStateHandle[STATE] = uiState
    }

    fun onChangeFullname(fullName: String) {
        savedStateHandle[FULLNAME] = fullName
    }

    fun onChangePhone(phone: String) {
        savedStateHandle[PHONE] = phone
    }

    fun onChangePassword(password: String) {
        savedStateHandle[PASSWORD] = password
    }

    fun OnChangePasswordonconfirm(passwordOnConfirm: String) {
        savedStateHandle[PASSWORDONCONFIRM] = passwordOnConfirm
    }
    fun addUser() = viewModelScope.launch{
        if(fullName.value.isNotEmpty()){
            if (phone.value.isNotEmpty()){
                if (password.value.isNotEmpty()){
                    if (password.value == passwordonconfirm.value) {
                        val user = userRepository.addUser(User( fullName.value, phone.value, password.value))
                        savedStateHandle[STATE] =
                            SignInUiState.Successful("ثبت نام با موفقیت انجام شد")
                    }
                } else {
                    savedStateHandle[STATE] = SignInUiState.Error("پسورد خود را وارد کنید")
                }
            } else {
                savedStateHandle[STATE] = SignInUiState.Error("شماره تلفن خود را وارد کنید")
            }
        }else {
            savedStateHandle[STATE] =
                SignInUiState.Error("نام و نام خوانوادگی خود را وارد کنید")
        }

    }
}

private const val STATE = "state"
private const val FULLNAME = "fullname"
private const val PHONE = "phone"
private const val PASSWORD = "password"
private const val PASSWORDONCONFIRM = "passwordonconfirm"
