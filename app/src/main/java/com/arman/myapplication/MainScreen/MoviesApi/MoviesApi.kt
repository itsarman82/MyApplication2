package com.arman.myapplication.MainScreen.MoviesApi

import com.arman.myapplication.MainScreen.MoviesApi.Movies
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    @GET("/api/v1/movies")
    fun getMovies(): Response<List<Movies>>
}