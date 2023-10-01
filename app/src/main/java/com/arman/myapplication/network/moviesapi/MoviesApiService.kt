package com.arman.myapplication.network.moviesapi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApiService {
    @GET("/api/v1/movies")
    suspend fun getMovies(
        @Query("name") name: String,
        @Query("page") page: Int
    ): Response<GetMovieResponse>

    @GET("/api/v1/genres")
    suspend fun getGenres() : Response<GetGenresResponse>

    @GET("/api/v1/movies/{movie_id}")
    suspend fun getSingleMove(@Path("movie_id") movie_id: Int) : Response<GetSingleMovieResponse>
}