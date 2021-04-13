package com.schweitzering.superheroesapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class NavigationManager(
    private val fragmentManager: FragmentManager?
) {

    fun open(fragment: Fragment) {
        fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, fragment)
                ?.addToBackStack(null)
                ?.commit()
    }
}