package com.example.recipesearchapp_assignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipesearchapp_assignment.databinding.ItemAllRecipeBinding
import com.example.recipesearchapp_assignment.databinding.ItemPopularRecipeBinding


data class Recipe(val name: String, val time: String, val imageResId: Int, val isPopular: Boolean)

class RecipeAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_POPULAR = 0
        private const val VIEW_TYPE_ALL = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (recipes[position].isPopular) VIEW_TYPE_POPULAR else VIEW_TYPE_ALL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_POPULAR) {
            val binding = ItemPopularRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            PopularRecipeViewHolder(binding)
        } else {
            val binding = ItemAllRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            AllRecipeViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recipe = recipes[position]
        if (holder is PopularRecipeViewHolder) {
            holder.bind(recipe)
        } else if (holder is AllRecipeViewHolder) {
            holder.bind(recipe)
        }
    }

    override fun getItemCount(): Int = recipes.size

    class PopularRecipeViewHolder(private val binding: ItemPopularRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.popularRecipeImage.setImageResource(recipe.imageResId)
            binding.popularRecipeName.text = recipe.name
            binding.popularRecipeTime.text = recipe.time
        }
    }

    class AllRecipeViewHolder(private val binding: ItemAllRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.allRecipeImage.setImageResource(recipe.imageResId)
            binding.allRecipeName.text = recipe.name
            binding.allRecipeTime.text = recipe.time
        }
    }
}