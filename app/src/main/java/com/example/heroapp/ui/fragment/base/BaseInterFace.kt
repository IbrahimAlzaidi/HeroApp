package com.example.heroapp.ui.fragment.base

import com.example.heroapp.model.response.heroModel.SuperHeroResponse

interface BaseInterFace {
    fun onSearchSuccess(hero : SuperHeroResponse)
    fun onSearchError(message:String)
    fun onSearchLoading()
}
