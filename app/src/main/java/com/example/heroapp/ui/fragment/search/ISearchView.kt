package com.example.heroapp.ui.fragment.search

import com.example.heroapp.model.response.heroModel.Heros

interface ISearchView {
    fun onSearchSuccess(hero: Heros)
}