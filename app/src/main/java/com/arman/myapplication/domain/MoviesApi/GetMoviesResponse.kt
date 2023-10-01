package com.arman.myapplication.domain.MoviesApi

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.time.Year


@Keep
data class GetMovieResponse(
    @SerializedName("data")
    val data:List<Movies>
) :Serializable

data class Movies(
    val id: Int,
    val title: String,
    val poster: String,
    val year: Year,
    val country: String,
    val imdb_rating: Double,
    val genres: List<String>,
    val images: List<String>
)