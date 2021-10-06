package com.example.heroapp.model.response.heroSearchResponse


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
data class SuperHeroPowerStats(
    @SerializedName("combat")
    val combat: String?,
    @SerializedName("durability")
    val durability: String?,
    @SerializedName("intelligence")
    val intelligence: String?,
    @SerializedName("power")
    val power: String?,
    @SerializedName("speed")
    val speed: String?,
    @SerializedName("strength")
    val strength: String?
) : Parcelable {
    override fun describeContents() = 0
    override fun writeToParcel(p0: Parcel?, p1: Int) {
    }
}
