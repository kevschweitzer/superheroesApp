package com.schweitzering.superheroesapp.data

import com.schweitzering.superheroesapp.domain.SuperHero
import com.schweitzering.superheroesapp.domain.SuperheroesRepository

class SuperheroesRepositoryImpl(
    private val superheroesService: SuperHeroesService
): SuperheroesRepository {

    override suspend fun getAllHeroes(): List<SuperHero> {
        return superheroesService.getAllCharacters().data.result
    }
}