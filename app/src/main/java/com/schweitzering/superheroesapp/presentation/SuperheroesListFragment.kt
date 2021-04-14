package com.schweitzering.superheroesapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.schweitzering.superheroesapp.R
import com.schweitzering.superheroesapp.base.BaseFragment
import com.schweitzering.superheroesapp.domain.SuperHero
import kotlinx.android.synthetic.main.fragment_superheroes_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SuperheroesListFragment : BaseFragment(), SuperheroesNavigationListener {

    private val superheroesViewModel: SuperheroesViewModel by sharedViewModel()
    private val superheroesAdapter = SuperheroesAdapter(superheroesNavigationListener = this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_superheroes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        observeSuperheroes()
        setRefreshButton()
    }

    private fun setRefreshButton() {
        refresh_button.setOnClickListener {
            superheroesViewModel.getSuperheroes()
        }
    }

    private fun setAdapter() {
        list_superheroes.apply {
            adapter = superheroesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeSuperheroes() {
        superheroesViewModel.superheroes.observe(
            viewLifecycleOwner,
            Observer {
                superheroesAdapter.setData(it)
            }
        )
    }

    override fun onSuperheroClicked(superhero: SuperHero) {
        superheroesViewModel.selectSuperhero(superhero)
        navigationManager.open(SuperheroesDetailFragment())
    }
}