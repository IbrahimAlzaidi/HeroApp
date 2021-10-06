package com.example.heroapp.model.response.heroSearchResponse


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
data class SuperHeroBiography(
    @SerializedName("aliases")
    val aliases: List<String>?,
    @SerializedName("alignment")
    val alignment: String?,
    @SerializedName("alter-egos")
    val alterEgos: String?,
    @SerializedName("first-appearance")
    val firstAppearance: String?,
    @SerializedName("full-name")
    val fullName: String?,
    @SerializedName("place-of-birth")
    val placeOfBirth: String?,
    @SerializedName("publisher")
    val publisher: String?
) : Parcelable {
    override fun describeContents() = 0
    override fun writeToParcel(p0: Parcel?, p1: Int) {
    }
}
