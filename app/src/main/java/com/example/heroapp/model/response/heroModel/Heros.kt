package com.example.heroapp.model.response.heroModel


import com.google.gson.annotations.SerializedName

 class Heros(
    @SerializedName("response")
    val response: String?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("results-for")
    val resultsFor: String?
)
