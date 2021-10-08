package com.example.heroapp.model.network

import com.example.heroapp.model.response.heroImageModel.HeroImage
import com.example.heroapp.model.response.heroModel.Heros
import com.example.heroapp.util.State
import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

object API {
    private val client = OkHttpClient()
    private val gson = Gson()
    private val builder = FormBody.Builder()
    fun build() {

    }

    fun makeRequestToGetHeroDetails(): State<Heros> {
        val request = Request.Builder()
            .url(UrlModify.getHeroUrlModify)
            .post(builder.build())
            .build()
        val response = client.newCall(request).execute()
        return if (response.isSuccessful) {
            val heroResponse = gson.fromJson(response.body?.string(), Heros::class.java)
            State.Success(heroResponse)
        } else {
            State.Error(response.message)
        }
    }

    fun makeRequestToGetHeroImage(): State<HeroImage> {
        val request = Request.Builder()
            .url(UrlModify.getImageHeroUrlModify)
            .post(builder.build())
            .build()
        val response = client.newCall(request).execute()
        return if (response.isSuccessful) {
            val heroImageResponse = gson.fromJson(response.body?.string(), HeroImage::class.java)
            State.Success(heroImageResponse)
        } else {
            State.Error(response.message)
        }
    }
}