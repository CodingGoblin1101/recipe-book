package com.example.recipe_book.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.recipe_book.data.model.navigateToAddRecipeScreen
import com.example.recipe_book.ui.components.RecipesColumn
import com.example.recipe_book.viewModel.RecipesViewModel

@Composable
fun MainScreen(
    viewModel: RecipesViewModel = viewModel(),
    navController: NavController,
    modifier: Modifier
) {
    val recipesState by viewModel.recipesState.observeAsState()

    when (val state = recipesState) {
        null -> {
            Text("Loading...", modifier = modifier)
        }

        else -> {
            Button(
                onClick = { navigateToAddRecipeScreen(
                    navController,
                    //logic to get newest recipeID here?
                    recipeId = 1
                ) },
                shape = ButtonDefaults.filledTonalShape,
            ) { Text("add recipe") }
            RecipesColumn(state)
        }
    }
}