package com.example.heroapp.model.network

object UrlModify {
    private var myHeroDetailsUrl: String = ""
    private var myHeroImageUrl: String = ""

    val getHeroUrlModify: String
        get() = myHeroDetailsUrl

    val getImageHeroUrlModify: String
        get() = myHeroImageUrl

    fun heroUrl(heroName: String) {
        myHeroDetailsUrl = "https://superheroapi.com/api/2992191684367509/search/$heroName"
    }

    fun mageHeroUrl(heroId: String?) {
        myHeroImageUrl = "https://superheroapi.com/api/2992191684367509/$heroId/image"
    }

}