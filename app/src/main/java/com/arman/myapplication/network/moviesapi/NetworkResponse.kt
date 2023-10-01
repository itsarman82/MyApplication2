package com.arman.myapplication.network.moviesapi

import java.io.Serializable

sealed interface NetworkResponse : Serializable {
    object Loading : NetworkResponse
    data class Error(val message: String) : NetworkResponse
    data class Success(val data: Any) : NetworkResponse
}