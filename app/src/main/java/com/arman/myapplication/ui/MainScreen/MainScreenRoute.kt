package com.arman.myapplication.ui.MainScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreenRoute(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.UiState.collectAsState()
    val movies by viewModel.listOfMovies.collectAsState()
    val genres by viewModel.listOfGenres.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(context ){
        viewModel.getMovies()
        viewModel.getGenres()
    }

    MainScreen(
        moviesList = movies,
        genresList = genres,
        onClickRefresh = viewModel::onRefreshData,
        mainScreenUIState = uiState
    )
}