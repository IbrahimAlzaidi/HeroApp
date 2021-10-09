package com.example.heroapp.ui.fragment.search

import com.example.heroapp.model.response.heroModel.Heros
import com.example.heroapp.util.State
import kotlinx.coroutines.flow.Flow

interface ISearchView {
    fun onDataFlow(hero : Flow<State<Heros>>)
}
