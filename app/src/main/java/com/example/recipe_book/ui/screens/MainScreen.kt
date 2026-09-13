package com.example.recipe_book.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipe_book.ui.components.RecipesColumn
import com.example.recipe_book.viewModel.RecipesViewModel

@Composable
fun MainScreen(modifier: Modifier,
               viewModel: RecipesViewModel = viewModel()) {
    val recipesState by viewModel.recipesState.collectAsStateWithLifecycle()

    when (val state = recipesState) {
        null -> {
            Text("Loading...", modifier = modifier)
        }

        else -> {
            RecipesColumn(state)
        }
    }
}