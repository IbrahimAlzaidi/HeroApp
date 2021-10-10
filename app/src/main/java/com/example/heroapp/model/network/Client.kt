package com.example.heroapp.model.network

import com.example.heroapp.model.response.heroImageModel.SuperHeroImageResponse
import com.example.heroapp.model.response.heroModel.SuperHeroResponse
import com.example.heroapp.util.State
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

object Client : IClient {
    private val client = OkHttpClient()
    private val checkResponse = Response(Gson())


    override fun makeRequestToGetHeroDetails(heroName: String): State<SuperHeroResponse> {
        val request = Request.Builder()
            .url("https://superheroapi.com/api/2992191684367509/search/$heroName")
            .build()
        val response = client.newCall(request).execute()
        return checkResponse.getCheckResponseDetailsSuperHero(
            response,
            SuperHeroResponse::class.java
        )
    }

    override fun makeRequestToGetHeroImage(heroId: String): State<SuperHeroImageResponse> {
        val request = Request.Builder()
            .url("https://superheroapi.com/api/2992191684367509/$heroId/image")
            .build()
        val response = client.newCall(request).execute()
        return checkResponse.getCheckResponseImageSuperHero(
            response,
            SuperHeroImageResponse::class.java
        )
    }
}
