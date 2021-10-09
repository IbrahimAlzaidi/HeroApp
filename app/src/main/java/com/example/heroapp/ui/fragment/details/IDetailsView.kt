package com.example.heroapp.ui.fragment.details

import com.example.heroapp.model.response.heroModel.SuperHeroResponse
import com.example.heroapp.util.State
import kotlinx.coroutines.flow.Flow

interface IDetailsView {
    fun onDataDetailsFlow(hero : Flow<State<SuperHeroResponse>>)
}