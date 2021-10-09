package com.example.heroapp.ui.fragment.search

import com.example.heroapp.model.response.heroModel.Result

interface IItemListener {
    fun onCardClicked(hero: Result?)
}
