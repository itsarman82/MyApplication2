package com.arman.myapplication.network

import com.arman.myapplication.network.moviesapi.GetGenresResponse
import com.arman.myapplication.network.moviesapi.GetMovieResponse
import com.arman.myapplication.network.moviesapi.MoviesApiInterface
import com.arman.myapplication.network.moviesapi.MoviesApiService
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: MoviesApiService
): MoviesApiInterface {
    override suspend fun getMovies(): Response<GetMovieResponse> =
        apiService.getMovies(name = "", page = 1)


    override suspend fun getGenre(): Response<GetGenresResponse> =
        apiService.getGenres()
}