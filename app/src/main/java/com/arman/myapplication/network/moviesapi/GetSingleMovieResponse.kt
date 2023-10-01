package com.arman.myapplication.network.moviesapi

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class GetSingleMovieResponse(
    @SerializedName("movie")
    val movie: List<Movie>
) : Serializable

@kotlinx.serialization.Serializable
data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster")
    val poster: String,
    @SerializedName("year")
    val year: String,
    @SerializedName("rated")
    val rated: String,
    @SerializedName("released")
    val released: String,
    @SerializedName("runtime")
    val runtime: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("writer")
    val writer: String,
    @SerializedName("actors")
    val actors: String,
    @SerializedName("plot")
    val plot: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("awards")
    val awards: String,
    @SerializedName("metascore")
    val metascore: String,
    @SerializedName("imdb_rating")
    val rating_rating: String,
    @SerializedName("imdb_votes")
    val imdb_votes: String,
    @SerializedName("imdb_id")
    val imdb_id: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("images")
    val images: List<String>
)