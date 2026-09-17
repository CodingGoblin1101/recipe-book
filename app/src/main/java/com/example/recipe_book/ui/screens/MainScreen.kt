package com.example.recipe_book.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipe_book.data.model.Recipe
import com.example.recipe_book.ui.components.RecipesColumn
import com.example.recipe_book.viewModel.RecipesViewModel

@Composable
fun MainScreen(
    modifier: Modifier,
    viewModel: RecipesViewModel = viewModel()
) {
    val recipesState by viewModel.recipesState.observeAsState()

    when (val state = recipesState) {
        null -> {
            Text("Loading...", modifier = modifier)
        }

        else -> {
            Button(
                //TODO: navigation to addRecipeScreen
                onClick = {
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
                shape = ButtonDefaults.filledTonalShape,
            ) { Text("add recipe") }
            RecipesColumn(state)
        }
    }
}