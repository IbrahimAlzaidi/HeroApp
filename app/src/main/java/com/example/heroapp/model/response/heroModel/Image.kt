package com.example.heroapp.model.response.heroModel


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("url")
    val url: String?
)
