package com.example.heroapp.util

import com.example.heroapp.model.response.heroModel.Result

interface CardViewListener {
    fun onCardClicked(hero: Result?)
}
