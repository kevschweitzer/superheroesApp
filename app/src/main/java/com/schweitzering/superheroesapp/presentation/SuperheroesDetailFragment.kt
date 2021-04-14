package com.schweitzering.superheroesapp.presentation

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.schweitzering.superheroesapp.R
import com.schweitzering.superheroesapp.base.BaseFragment
import com.schweitzering.superheroesapp.databinding.FragmentSuperheroesDetailBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SuperheroesDetailFragment : BaseFragment() {

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

    override fun onBackPressed() {
        AlertDialog.Builder(context)
                .setMessage("Estas seguro que queres ir para atras?")
                .setPositiveButton("Aceptar"){_, _ ->
                    navigationManager.goBack()
                }
                .setNegativeButton("Cancelar") {_,_ ->}
                .create()
                .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        itemBinding = null
    }
}