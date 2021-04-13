package com.schweitzering.superheroesapp.domain

interface SuperheroesRepository {

    suspend fun getAllHeroes(): List<SuperHero>
}