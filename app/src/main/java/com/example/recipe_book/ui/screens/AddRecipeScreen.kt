package com.example.recipe_book.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipe_book.data.model.Recipe
import com.example.recipe_book.viewModel.RecipesViewModel

@Composable
fun AddRecipeScreen(viewModel: RecipesViewModel = viewModel()) {
    //TODO: build JSON to send to API
    Column(
    Modifier.padding(10.dp)
    ) {
        Button(onClick = { viewModel.addRecipes(
            Recipe(
                name = "Pasta",
                ingredients = mapOf("Tomato" to "2"),
                steps = listOf("Cook pasta", "Boil water"),
                notes = "Something",
                pictures = "" //Platzhalter
            )
        ) }) {         Text("add a new recipe") }

    }
}