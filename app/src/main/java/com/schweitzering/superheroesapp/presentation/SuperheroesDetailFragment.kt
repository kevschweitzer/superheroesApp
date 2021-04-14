package com.schweitzering.superheroesapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.schweitzering.superheroesapp.R
import com.schweitzering.superheroesapp.databinding.FragmentSuperheroesDetailBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SuperheroesDetailFragment : Fragment() {

    private val superheroesViewModel: SuperheroesViewModel by sharedViewModel()
    private var itemBinding: FragmentSuperheroesDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_superheroes_detail, container, false
        )
        itemBinding?.superhero = superheroesViewModel.selectedSuperhero
        return itemBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        itemBinding = null
    }
}