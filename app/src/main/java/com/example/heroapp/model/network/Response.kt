package com.example.heroapp.model.network

import com.example.heroapp.model.response.heroImageModel.SuperHeroImageResponse
import com.example.heroapp.model.response.heroModel.SuperHeroResponse
import com.example.heroapp.util.State
import com.google.gson.Gson
import okhttp3.Response

class Response(private val gson: Gson) : ICheckResponse {
    override fun getCheckResponseImageSuperHero(
        response: Response,
        heroResponse: Class<SuperHeroImageResponse>
    ): State<SuperHeroImageResponse> {
        return if (response.isSuccessful) {
            val heroResponse = gson.fromJson(response.body?.string(), heroResponse)
            State.Success(heroResponse)
        } else {
            State.Error(response.message)
        }
    }

    override fun getCheckResponseDetailsSuperHero(
        response: Response,
        heroResponse: Class<SuperHeroResponse>
    ): State<SuperHeroResponse> {
        return if (response.isSuccessful) {
            val heroImageResponse = gson.fromJson(response.body?.string(), heroResponse)
            State.Success(heroImageResponse)
        } else {
            State.Error(response.message)
        }
    }

}
