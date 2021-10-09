package com.example.heroapp.ui.fragment.details

import com.example.heroapp.model.Repository
import com.example.heroapp.ui.fragment.base.BasePresenter

class DetailsPresenter(private var view: IDetailsView) : BasePresenter() {
    fun getDetailsOfSuperHero(text: String) {
        view.onDataDetailsFlow(Repository.getHeroImage(text))
    }
}