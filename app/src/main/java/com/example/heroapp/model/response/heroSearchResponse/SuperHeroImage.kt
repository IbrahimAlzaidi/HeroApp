package com.example.heroapp.model.response.heroSearchResponse


import com.google.gson.annotations.SerializedName

data class SuperHeroImage(
    @SerializedName("url")
    val url: String?
)
