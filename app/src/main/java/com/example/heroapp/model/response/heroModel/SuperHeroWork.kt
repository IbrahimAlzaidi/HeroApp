package com.example.heroapp.model.response.heroModel


import com.google.gson.annotations.SerializedName

data class SuperHeroWork(
    @SerializedName("base")
    val base: String?,
    @SerializedName("occupation")
    val occupation: String?
)
