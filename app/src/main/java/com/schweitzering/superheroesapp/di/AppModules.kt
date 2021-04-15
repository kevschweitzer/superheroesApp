package com.schweitzering.superheroesapp.di

import androidx.fragment.app.FragmentManager
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.schweitzering.superheroesapp.NavigationManager
import com.schweitzering.superheroesapp.data.SuperHeroesService
import com.schweitzering.superheroesapp.data.SuperheroesRepositoryImpl
import com.schweitzering.superheroesapp.domain.GetAllSuperHeroesUseCase
import com.schweitzering.superheroesapp.domain.SuperheroesRepository
import com.schweitzering.superheroesapp.presentation.SuperheroesViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val client = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor()).build()

val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://gateway.marvel.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

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
        SuperheroesRepositoryImpl(
            retrofit.create(SuperHeroesService::class.java)
        )
    }

    single {
        (fragmentManager: FragmentManager?) ->
        NavigationManager(fragmentManager)
    }
}