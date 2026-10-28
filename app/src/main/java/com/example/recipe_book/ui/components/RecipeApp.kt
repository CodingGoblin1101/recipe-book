package com.example.recipe_book.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipe_book.data.model.Screen
import com.example.recipe_book.data.model.navigateToAddRecipeScreen
import com.example.recipe_book.ui.screens.AddRecipeScreen
import com.example.recipe_book.ui.screens.MainScreen
import com.example.recipe_book.ui.screens.RecipeDetailScreen
import com.example.recipe_book.viewModel.RecipesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp() {
    val viewModel: RecipesViewModel = viewModel()
    val navController = rememberNavController()

    RecipeAppContent(viewModel, navController)
}

@Composable
fun RecipeAppContent(viewModel: RecipesViewModel, navController: NavHostController) {
    Scaffold(
        topBar = { TopBar(
            onHomeClick = {
                // TODO: read about that: Navigate to home and clear the backstack to prevent loops
                navController.navigate(Screen.Main.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                    launchSingleTop = true
                } },
            onSearchClick = { /*TODO*/ },
        ) },
        floatingActionButton = { ActionButton { navigateToAddRecipeScreen(navController, 1) } },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Main.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = Screen.Main.route, content =
                    {
                        MainScreen()
                    })
            composable(
                Screen.AddRecipe.route, content =
                    {
                        AddRecipeScreen(viewModel)
                    })
            composable(
                Screen.RecipeDetail.route, content =
                    {
                        RecipeDetailScreen(viewModel)
                    })
        }
    }
}