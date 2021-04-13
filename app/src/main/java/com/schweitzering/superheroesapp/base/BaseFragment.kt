package com.schweitzering.superheroesapp.base

import androidx.fragment.app.Fragment
import com.schweitzering.superheroesapp.NavigationManager
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class BaseFragment: Fragment() {
    protected val navigationManager: NavigationManager by inject { parametersOf(activity?.supportFragmentManager) }
}