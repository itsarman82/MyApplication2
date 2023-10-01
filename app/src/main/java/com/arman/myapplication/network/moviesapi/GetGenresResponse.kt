package com.arman.myapplication.network.moviesapi

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class GetGenresResponse(
    @SerializedName("data")
    val Genre: List<Genre>
): Serializable

@kotlinx.serialization.Serializable
data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)