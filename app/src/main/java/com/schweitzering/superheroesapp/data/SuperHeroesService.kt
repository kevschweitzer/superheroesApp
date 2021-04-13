package com.schweitzering.superheroesapp.data

import com.schweitzering.superheroesapp.domain.SuperHero
import com.schweitzering.superheroesapp.domain.SuperHeroesWrapper
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface SuperHeroesService {

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query("apikey") apikey: String = "3f310cf55ba6790fa035559c9008a112",
        @Query("hash") hash: String = "8ec8048628acdfc7fac526884befb1fa",
        @Query("ts") ts: String = "1"
    ): SuperHeroesWrapper
}