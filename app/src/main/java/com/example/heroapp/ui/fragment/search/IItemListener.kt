package com.example.heroapp.ui.fragment.search

import com.example.heroapp.model.response.heroModel.SuperHeroResult

interface IItemListener {
    fun onItemClickListener(hero: SuperHeroResult?)
}
