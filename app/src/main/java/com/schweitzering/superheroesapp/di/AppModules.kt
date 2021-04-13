package com.schweitzering.superheroesapp.di

import androidx.fragment.app.FragmentManager
import com.schweitzering.superheroesapp.NavigationManager
import com.schweitzering.superheroesapp.data.SuperheroesRepositoryImpl
import com.schweitzering.superheroesapp.domain.GetAllSuperHeroesUseCase
import com.schweitzering.superheroesapp.domain.SuperheroesRepository
import com.schweitzering.superheroesapp.presentation.SuperheroesViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        SuperheroesViewModel(
            get() as GetAllSuperHeroesUseCase
        )
    }

    factory {
        GetAllSuperHeroesUseCase(
            get() as SuperheroesRepository
        )
    }

    factory<SuperheroesRepository> {
        SuperheroesRepositoryImpl()
    }

    single {
        (fragmentManager: FragmentManager?) ->
        NavigationManager(fragmentManager)
    }
}