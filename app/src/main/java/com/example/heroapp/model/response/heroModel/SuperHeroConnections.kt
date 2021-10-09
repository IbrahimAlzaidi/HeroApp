package com.example.heroapp.model.response.heroModel


import com.google.gson.annotations.SerializedName

data class SuperHeroConnections(
    @SerializedName("group-affiliation")
    val groupAffiliation: String?,
    @SerializedName("relatives")
    val relatives: String?
)
