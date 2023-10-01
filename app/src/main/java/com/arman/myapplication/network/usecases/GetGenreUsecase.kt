package com.arman.myapplication.network.usecases

import javax.inject.Inject
import com.arman.myapplication.network.RemoteDataSource
import com.arman.myapplication.network.moviesapi.NetworkResponse
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow


class GetGenreUsecase @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    operator fun invoke(): Flow<NetworkResponse> = flow {
        try {
            emit(NetworkResponse.Loading)
            val response = remoteDataSource.getGenre()
            if (response.isSuccessful)
                emit(NetworkResponse.Success(response.body()!!))
            else
                emit((NetworkResponse.Error("مشکلی در برقراری ارتباط با سرور پیش آمده است")))
        }catch (e: Exception) {
            emit(NetworkResponse.Error("مشکلی در برقراری ارتباط با سرور پیش آمده است"))
        }
    }
}