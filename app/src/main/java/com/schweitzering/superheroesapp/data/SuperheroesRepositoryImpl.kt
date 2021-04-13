package com.schweitzering.superheroesapp.data

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.schweitzering.superheroesapp.domain.SuperHero
import com.schweitzering.superheroesapp.domain.SuperheroesRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperheroesRepositoryImpl: SuperheroesRepository {

    val cliente = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor()).build()

    val retrofit = Retrofit.Builder()
        .client(cliente)
        .baseUrl("https://gateway.marvel.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override suspend fun getAllHeroes(): List<SuperHero> {
        return retrofit.create(SuperHeroesService::class.java).getAllCharacters().data.result
    }
}