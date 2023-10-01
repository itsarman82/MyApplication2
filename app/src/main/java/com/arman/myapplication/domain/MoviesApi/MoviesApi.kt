package com.arman.myapplication.domain.MoviesApi

import com.arman.myapplication.domain.MoviesApi.Movies
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    @GET("/api/v1/movies?page={page}")
    fun getMovies(): Response<GetMovieResponse>
}