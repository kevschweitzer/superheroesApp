package com.schweitzering.superheroesapp.domain

import com.google.gson.annotations.SerializedName

data class SuperHeroesWrapper(
    @SerializedName("data") var data: ResultWrapper
)

data class ResultWrapper(
    @SerializedName("results") var result: List<SuperHero>
)

data class SuperHero(
    @SerializedName("id") val id: Int,
    @SerializedName("name")var name: String,
    @SerializedName("description")var description: String
)