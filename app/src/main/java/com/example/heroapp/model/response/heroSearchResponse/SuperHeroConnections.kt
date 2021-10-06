package com.example.heroapp.model.response.heroSearchResponse


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
data class SuperHeroConnections(
    @SerializedName("group-affiliation")
    val groupAffiliation: String?,
    @SerializedName("relatives")
    val relatives: String?
) : Parcelable {
    override fun describeContents() = 0
    override fun writeToParcel(p0: Parcel?, p1: Int) {
    }
}
