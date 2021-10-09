package com.example.heroapp.ui.fragment.search

import com.example.heroapp.model.response.heroModel.SuperHeroResponse
import com.example.heroapp.util.State
import kotlinx.coroutines.flow.Flow

interface ISearchView {
    fun onDataSearchFlow(hero : Flow<State<SuperHeroResponse>>)
}
