package com.schweitzering.superheroesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.schweitzering.superheroesapp.base.BaseFragment
import com.schweitzering.superheroesapp.presentation.SuperheroesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupInitialFragment()
    }

    private fun setupInitialFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, SuperheroesListFragment())
                .commit()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(fragment is BaseFragment) {
            fragment.onBackPressed()
        } else super.onBackPressed()
    }
}