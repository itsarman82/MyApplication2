package com.arman.myapplication.Signin

import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.LayoutDirection
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SigninScreen(
    fullname: String,
    phone: String,
    password: String,
    passwordonconfirm: String,
    onChangeFullname:(String) -> Unit,
    onChangePhone:(String) -> Unit,
    onChangePassword:(String) -> Unit,
    OnChangePasswordonconfirm:(String) -> Unit,
    onClickSignIn: () -> Unit,
    ) {
    var passwdVisible by remember { mutableStateOf(false) }

    CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "ثبت نام",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "لطفا برای ثبت نام اطلاعات خود را وارد کنید",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(15.dp),
                value = fullname,
                onValueChange = {
                    onChangeFullname(it)
                },
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "",
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                label = {
                    Text(
                        text = "نام و نام خوانوداگی"
                    )
                }
            )

            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(15.dp),
                value = phone,
                onValueChange = {
                    onChangePhone(it)
                },
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "",
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                label = {
                    Text(
                        text = "موبایل یا ایمیل"
                    )
                }
            )

            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(15.dp),
                value = password,
                onValueChange = {
                    onChangePassword(it)
                },
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "",
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                label = {
                    Text(
                        text = "رمز عبور"
                    )
                },
                visualTransformation = if (passwdVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwdVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description = if (passwdVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwdVisible = !passwdVisible}){
                        Icon(imageVector  = image, description)
                    }
                }

            )

            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(15.dp),
                value = passwordonconfirm,
                onValueChange = {
                    OnChangePasswordonconfirm(it)
                },
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "",
                        modifier = Modifier.alpha(0.5f)
                    )
                },
                label = {
                    Text(
                        text = "تایید رمز عبور"
                    )
                },
                visualTransformation = if (passwdVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwdVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description = if (passwdVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwdVisible = !passwdVisible}){
                        Icon(imageVector  = image, description)
                    }
                }

            )

            Spacer(modifier = Modifier.height((40.dp)))
            Button(
                modifier = Modifier.fillMaxWidth(0.40f),
                shape = RoundedCornerShape(12.dp),
                onClick = {
                    onClickSignIn()
                },
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 10.dp,
                )
            ) {
                Text(
                    text = "ثبت نام"
                )
            }
        }
    }
}