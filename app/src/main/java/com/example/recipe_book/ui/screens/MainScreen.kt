package com.example.recipe_book.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.recipe_book.data.model.ProductResponse
import com.example.recipe_book.data.model.navigateToAddRecipeScreen
import com.example.recipe_book.ui.components.RecipesColumn
import com.example.recipe_book.ui.components.Topbar
import com.example.recipe_book.viewModel.RecipesViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: RecipesViewModel = viewModel()
) {
    val recipesState by viewModel.recipesState.observeAsState()

    MainScreenContent(
        recipesState = recipesState,
        onAddRecipeClick = { navigateToAddRecipeScreen(navController, recipeId = 1) },
        modifier = modifier
    )
}

@Composable
fun MainScreenContent(
    recipesState: ProductResponse?,
    onAddRecipeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (recipesState) {
        null -> {
            Text("Loading...", modifier = modifier)
        }

        else -> {
            Column(modifier = modifier) {
                Topbar(onAddRecipeClick)
                RecipesColumn(recipesState)
            }
        }
    }
}
