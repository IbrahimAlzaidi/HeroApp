package com.example.heroapp.ui.fragment.base

import com.example.heroapp.model.response.heroModel.Heros

interface BaseInterFace {
    fun onSearchSuccess(hero : Heros)
    fun onSearchError(message:String)
    fun onSearchLoading()
}
