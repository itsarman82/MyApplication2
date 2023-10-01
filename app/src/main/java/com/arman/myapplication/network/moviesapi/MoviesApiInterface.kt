package com.arman.myapplication.network.moviesapi

import retrofit2.Response

interface MoviesApiInterface {
    suspend fun getMovies(): Response<GetMovieResponse>
    suspend fun getGenre(): Response<GetGenresResponse>
}