package com.example.recipesearchapp_assignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipesearchapp_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        binding.bottomNavigationView.menu.findItem(R.id.nav_home).isChecked =true

        setupAllRecipes()
        setupPopularRecipes()

    }

    private fun setupPopularRecipes(){
        binding.popularRecipesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val popularRecipes = listOf(
            Recipe("", "", R.drawable.shahi_paneer,true),
            Recipe("", "", R.drawable.image1,true),
            Recipe("", "", R.drawable.image2,true)
        )
        val adapter = RecipeAdapter(popularRecipes)
        binding.popularRecipesRecyclerView.adapter = adapter
    }

    private fun setupAllRecipes() {
        binding.allRecipesRecyclerView.layoutManager = LinearLayoutManager(this)
        val allRecipes = listOf(
            Recipe("Recipe name goes here", "Ready in 25 min", R.drawable.image1,false),
            Recipe("Recipe name goes here", "Ready in 25 min", R.drawable.image2,false),
            Recipe("Recipe name goes here", "Ready in 25 min", R.drawable.shahi_paneer,false)
            // Add more recipes as needed
        )
        val adapter = RecipeAdapter(allRecipes)
        binding.allRecipesRecyclerView.adapter = adapter
    }

}