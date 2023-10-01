package com.arman.myapplication.ui.MainScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arman.myapplication.network.moviesapi.Movies
import com.arman.myapplication.network.moviesapi.Genre
import com.arman.myapplication.network.moviesapi.GetMovieResponse
import com.arman.myapplication.network.moviesapi.NetworkResponse
import com.arman.myapplication.network.usecases.GetGenreUsecase
import com.arman.myapplication.network.usecases.GetMoviesUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getMoviesUsecases: GetMoviesUsecases,
    private val getGenreUsecase: GetGenreUsecase

) : ViewModel() {

    val listOfMovies: StateFlow<List<Movies>> = savedStateHandle.getStateFlow(MOVIES, arrayListOf<Movies>())
    val listOfGenres: StateFlow<List<Genre>> = savedStateHandle.getStateFlow(GENRES, arrayListOf<Genre>())
    val UiState: StateFlow<MainScreenUIState> = savedStateHandle.getStateFlow(
        STATE,
        MainScreenUIState.Content
    )
    fun getMovies() = viewModelScope.launch {
        getMoviesUsecases.invoke().collect { response ->
            when (response) {
                is NetworkResponse.Error -> savedStateHandle[STATE] =
                    MainScreenUIState.Error(response.message)

                NetworkResponse.Loading -> savedStateHandle[STATE] =
                    MainScreenUIState.Loading

                is NetworkResponse.Success -> {
                    savedStateHandle[MOVIES] = (response.data as GetMovieResponse).data
                    savedStateHandle[STATE] = MainScreenUIState.Content
                }
            }
        }
    }

    fun getGenres() = viewModelScope.launch {
        getGenreUsecase.invoke().collect { response ->
            when (response) {
                is NetworkResponse.Error -> savedStateHandle[STATE] =
                    MainScreenUIState.Error(response.message)

                NetworkResponse.Loading -> savedStateHandle[STATE] =
                    MainScreenUIState.Loading

                is NetworkResponse.Success -> {
                    savedStateHandle[GENRES] = (response.data as List<*>)
                    savedStateHandle[STATE] = MainScreenUIState.Content
                }
            }
        }
    }

    fun onRefreshData() {
        getMovies()
        getGenres()
    }
}

private const val GENRES = "genres"
private const val MOVIES = "movie"
private const val STATE = "state"
