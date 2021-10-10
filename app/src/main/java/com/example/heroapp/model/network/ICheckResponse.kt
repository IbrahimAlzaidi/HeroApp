package com.example.heroapp.model.network

import com.example.heroapp.model.response.heroImageModel.SuperHeroImageResponse
import com.example.heroapp.model.response.heroModel.SuperHeroResponse
import com.example.heroapp.util.State
import okhttp3.Response

interface ICheckResponse {
    fun getCheckResponseImageSuperHero(
        response: Response,
        heroResponse: Class<SuperHeroImageResponse>
    ): State<SuperHeroImageResponse>

    fun getCheckResponseDetailsSuperHero(
        response: Response,
        heroResponse: Class<SuperHeroResponse>
    ): State<SuperHeroResponse>
}
