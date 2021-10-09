package com.example.heroapp.model.network

import com.example.heroapp.model.response.heroImageModel.SuperHeroImageResponse
import com.example.heroapp.model.response.heroModel.SuperHeroResponse
import com.example.heroapp.util.State
import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

object API {
    private val client = OkHttpClient()
    private val gson = Gson()
    private val builder = FormBody.Builder()
    fun build(){

    }

    fun makeRequestToGetHeroDetails(): State<SuperHeroResponse> {
        val request = Request.Builder()
            .url(UrlModify.getHeroUrlModify)
            .post(builder.build())
            .build()
        val response = client.newCall(request).execute()
        return if (response.isSuccessful) {
            val heroResponse = gson.fromJson(response.body?.string(), SuperHeroResponse::class.java)
            State.Success(heroResponse)
        } else {
            State.Error(response.message)
        }
    }

    fun makeRequestToGetHeroImage(): State<SuperHeroImageResponse> {
        val request = Request.Builder()
            .url(UrlModify.getImageHeroUrlModify)
            .post(builder.build())
            .build()
        val response = client.newCall(request).execute()
        return if (response.isSuccessful) {
            val heroImageResponse = gson.fromJson(response.body?.string(), SuperHeroImageResponse::class.java)
            State.Success(heroImageResponse)
        } else {
            State.Error(response.message)
        }
    }
}