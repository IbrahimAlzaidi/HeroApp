package com.example.heroapp.model.response.heroImageModel


import com.google.gson.annotations.SerializedName

data class HeroImage(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("response")
    val response: String?,
    @SerializedName("url")
    val url: String?
)
