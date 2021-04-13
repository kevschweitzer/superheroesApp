package com.schweitzering.superheroesapp.presentation

import androidx.lifecycle.*
import com.schweitzering.superheroesapp.data.SuperheroesRepositoryImpl
import com.schweitzering.superheroesapp.domain.GetAllSuperHeroesUseCase
import com.schweitzering.superheroesapp.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperheroesViewModel(
    private val getSuperHeroesUseCase: GetAllSuperHeroesUseCase
): ViewModel() {

    private val _superheroes = MutableLiveData<List<SuperHero>>()
    val superheroes: LiveData<List<SuperHero>>
        get() = _superheroes

    var selectedSuperhero: SuperHero? = null

    init {
        getSuperheroes()
    }

    fun getSuperheroes() {
        viewModelScope.launch {
            _superheroes.postValue(getSuperHeroesUseCase.execute())
        }
    }

    fun selectSuperhero(superHero: SuperHero) {
        selectedSuperhero = superHero
    }
}