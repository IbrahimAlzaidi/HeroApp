package com.example.testapplication.model


import com.google.gson.annotations.SerializedName

 class Heros(
    @SerializedName("response")
    val response: String?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("results-for")
    val resultsFor: String?
)
