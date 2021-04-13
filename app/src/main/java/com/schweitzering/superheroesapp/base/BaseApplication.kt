package com.schweitzering.superheroesapp.base

import android.app.Application
import com.facebook.stetho.Stetho
import com.schweitzering.superheroesapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        startKoin{
            androidLogger()
            androidContext(this@BaseApplication)
            modules(appModule)
        }
    }
}