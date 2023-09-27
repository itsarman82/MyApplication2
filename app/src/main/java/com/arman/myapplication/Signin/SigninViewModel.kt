package com.arman.myapplication.Signin

import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arman.myapplication.data.User
import com.arman.myapplication.data.UserRepository
import com.arman.myapplication.login.LoginUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SigninViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userRepository: UserRepository
) : ViewModel() {
    val fullName = savedStateHandle.getStateFlow(FULLNAME, "")
    val phone = savedStateHandle.getStateFlow(PHONE,"")
    val password = savedStateHandle.getStateFlow(PASSWORD, "")
    val passwordonconfirm = savedStateHandle.getStateFlow(PASSWORDONCONFIRM,"")
    val uiState:StateFlow<SigninUIStateUIState> = savedStateHandle.getStateFlow(STATE, SigninUIStateUIState.Loading)

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
                        savedStateHandle[STATE] = SigninUIStateUIState.Successful("ثبت نام با موفقیت انجام شد")
                    }
                } else {
                    savedStateHandle[STATE] = SigninUIStateUIState.Error("پسورد خود را وارد کنید")
                }
            } else {
                savedStateHandle[STATE] = SigninUIStateUIState.Error("شماره تلفن خود را وارد کنید")
            }
        }else {
            savedStateHandle[STATE] = SigninUIStateUIState.Error("نام و نام خوانوادگی خود را وارد کنید")
        }

    }
}

private const val STATE = "state"
private const val FULLNAME = "fullname"
private const val PHONE = "phone"
private const val PASSWORD = "password"
private const val PASSWORDONCONFIRM = "passwordonconfirm"
