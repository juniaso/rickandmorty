package com.sync.rickandmorty

import com.google.gson.annotations.SerializedName

data class Character (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: Origin,
    @SerializedName("location") val location: Location,
    @SerializedName("image") val image: String
)

data class Origin(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Location(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
