package com.example.heroapp.model.response.heroModel

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
class SuperHeroResponse(
    @SerializedName("response")
    val response: String?,
    @SerializedName("results")
    val results: List<SuperHeroResult>?,
    @SerializedName("results-for")
    val resultsFor: String?
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }
}

