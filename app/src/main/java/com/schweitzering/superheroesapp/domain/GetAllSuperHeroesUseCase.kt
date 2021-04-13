package com.schweitzering.superheroesapp.domain

class GetAllSuperHeroesUseCase(
    private val repository: SuperheroesRepository
) {

    suspend fun execute(): List<SuperHero> {
        return repository.getAllHeroes()
    }
}