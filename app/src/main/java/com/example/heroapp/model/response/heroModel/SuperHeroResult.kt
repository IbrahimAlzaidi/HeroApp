package com.example.heroapp.model.response.heroModel

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
data class SuperHeroResult(
    @SerializedName("appearance")
    val appearance: SuperHeroAppearance?,
    @SerializedName("biography")
    val biography: SuperHeroBiography?,
    @SerializedName("connections")
    val connections: SuperHeroConnections?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: SuperHeroImage?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("powerstats")
    val powerstats: SuperHeroPowerstats?,
    @SerializedName("work")
    val work: SuperHeroWork?
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }
}
