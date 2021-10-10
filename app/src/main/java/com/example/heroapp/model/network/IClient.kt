package com.example.heroapp.model.network

import com.example.heroapp.model.response.heroImageModel.SuperHeroImageResponse
import com.example.heroapp.model.response.heroModel.SuperHeroResponse
import com.example.heroapp.util.State

interface IClient {
    fun makeRequestToGetHeroDetails(heroName: String): State<SuperHeroResponse>
    fun makeRequestToGetHeroImage(heroId: String): State<SuperHeroImageResponse>
}
