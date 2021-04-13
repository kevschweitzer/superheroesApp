package com.schweitzering.superheroesapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.schweitzering.superheroesapp.R
import com.schweitzering.superheroesapp.databinding.ItemSuperheroBinding
import com.schweitzering.superheroesapp.domain.SuperHero

interface SuperheroesNavigationListener {
    fun onSuperheroClicked(superhero: SuperHero)
}

class SuperheroesAdapter(
    private var superheroes: List<SuperHero> = mutableListOf(),
    private val superheroesNavigationListener: SuperheroesNavigationListener
): RecyclerView.Adapter<SuperheroesAdapter.SuperheroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = DataBindingUtil.inflate<ItemSuperheroBinding>(
            inflater, R.layout.item_superhero, parent, false
        )
        return SuperheroViewHolder(itemBinding, superheroesNavigationListener)
    }

    override fun getItemCount() = superheroes.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(superheroes[position])
    }

    fun setData(superheroes: List<SuperHero>) {
        this.superheroes = superheroes
        notifyDataSetChanged()
    }

    inner class SuperheroViewHolder(
        private val view: ItemSuperheroBinding,
        private val listener: SuperheroesNavigationListener
    ): RecyclerView.ViewHolder(view.root) {

        fun bind(superhero: SuperHero) {
            view.superhero = superhero
            view.listener = listener
        }
    }
}