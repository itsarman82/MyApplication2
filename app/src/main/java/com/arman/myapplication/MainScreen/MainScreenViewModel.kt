package com.arman.myapplication.MainScreen

import android.graphics.Movie
import androidx.compose.runtime.MutableState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arman.myapplication.MainScreen.MoviesApi.MoviesApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val moviesApi: MoviesApi,
    private val SavedStateHandle: SavedStateHandle
) : ViewModel() {

    fun getMovies() = viewModelScope.launch {
        val response = moviesApi.getMovies()
        if (response.isSuccessful){

        }else{
            throw Exception("asd;jf;ldsajf")
        }
    }

}