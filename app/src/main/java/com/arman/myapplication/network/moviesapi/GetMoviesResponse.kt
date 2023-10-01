package com.arman.myapplication.network.moviesapi

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Keep
data class GetMovieResponse(
    @SerializedName("data")
    val data:List<Movies>,
    @SerializedName("metadata")
    val metadata: MovieMetadata
) : Serializable

@kotlinx.serialization.Serializable
data class Movies(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster")
    val poster: String,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("images")
    val images: List<String>,
)

@kotlinx.serialization.Serializable
data class MovieMetadata(
    @SerializedName("current_page")
    val current_page: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("page_count")
    val page_count: Int,
    @SerializedName("total_pages")
    val total_pages: Int
)