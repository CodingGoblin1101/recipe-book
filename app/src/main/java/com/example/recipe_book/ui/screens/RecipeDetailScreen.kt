package com.example.recipe_book.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.recipe_book.data.model.Recipe
import com.example.recipe_book.viewModel.RecipesViewModel

@Composable
fun RecipeDetailScreen(viewModel: RecipesViewModel){
    Button(
        onClick =
            {
                viewModel.addRecipes(
                    Recipe(
                        name = "Pasta",
                        ingredients = mapOf("Tomato" to "2"),
                        steps = listOf("Cook pasta", "Boil water"),
                        notes = "Something",
                        pictures = ""
                    )
                )
            },
    ){
        Text("add recipe")
    }
}