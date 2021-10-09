package com.example.heroapp.ui.fragment.search

import com.example.heroapp.model.Repository
import com.example.heroapp.ui.fragment.base.BasePresenter

class SearchPresenter(private var view: ISearchView): BasePresenter() {

    fun getResultOfSearch(text:String){
        view.onDataSearchFlow(Repository.getHeroImage(text))
    }
}
