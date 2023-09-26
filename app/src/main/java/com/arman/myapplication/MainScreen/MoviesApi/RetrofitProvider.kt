package com.arman.myapplication.MainScreen.MoviesApi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
class RetrofitProvider {
    @Provides
    fun providesRetrofit() :Retrofit {
        return Retrofit.Builder().baseUrl("https://moviesapi.ir").build()
    }

    @Provides
    fun providesMoviesApiRepository(retrofit: Retrofit): MoviesApi{
        return retrofit.create(MoviesApi::class.java)
    }
}