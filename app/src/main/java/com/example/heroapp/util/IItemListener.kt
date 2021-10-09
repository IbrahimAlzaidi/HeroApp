package com.example.heroapp.util

import com.example.heroapp.model.response.heroModel.Result

interface IItemListener {
    fun onCardClicked(hero: Result?)
}
