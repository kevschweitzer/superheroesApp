package com.schweitzering.superheroesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}