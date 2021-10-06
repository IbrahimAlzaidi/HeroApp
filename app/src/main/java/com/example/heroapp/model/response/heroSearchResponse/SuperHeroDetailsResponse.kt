package com.example.heroapp.model.response.heroSearchResponse


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
data class SuperHeroDetailsResponse(
    @SerializedName("appearance")
    val superHeroAppearance: SuperHeroAppearance?,
    @SerializedName("biography")
    val superHeroBiography: SuperHeroBiography?,
    @SerializedName("connections")
    val superHeroConnections: SuperHeroConnections?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val superHeroImage: SuperHeroImage?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("powerstats")
    val superHeroPowerStats: SuperHeroPowerStats?,
    @SerializedName("work")
    val superHeroWork: SuperHeroWork?
) : Parcelable {
    override fun describeContents() = 0
    override fun writeToParcel(p0: Parcel?, p1: Int) {
    }
}
