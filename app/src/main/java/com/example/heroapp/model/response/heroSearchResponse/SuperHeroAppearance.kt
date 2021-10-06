package com.example.heroapp.model.response.heroSearchResponse


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
data class SuperHeroAppearance(
    @SerializedName("eye-color")
    val eyeColor: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("hair-color")
    val hairColor: String?,
    @SerializedName("height")
    val height: List<String>?,
    @SerializedName("race")
    val race: String?,
    @SerializedName("weight")
    val weight: List<String>?
) : Parcelable {
    override fun describeContents() = 0
    override fun writeToParcel(p0: Parcel?, p1: Int) {
    }
}
