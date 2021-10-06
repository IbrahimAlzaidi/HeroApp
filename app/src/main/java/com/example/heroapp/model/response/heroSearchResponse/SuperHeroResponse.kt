package com.example.heroapp.model.response.heroSearchResponse


import com.google.gson.annotations.SerializedName

 class SuperHeroResponse(
    @SerializedName("response")
    val response: String?,
    @SerializedName("results")
    val superHeroDetailResponses: List<SuperHeroDetailsResponse>?,
    @SerializedName("results-for")
    val resultsFor: String?
)
