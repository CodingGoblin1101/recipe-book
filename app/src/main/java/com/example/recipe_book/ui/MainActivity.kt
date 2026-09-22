package com.example.recipe_book.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipe_book.data.model.Screen
import com.example.recipe_book.ui.screens.AddRecipeScreen
import com.example.recipe_book.ui.screens.MainScreen
import com.example.recipe_book.ui.screens.RecipeDetailScreen
import com.example.recipe_book.ui.theme.RecipebookTheme
import com.example.recipe_book.viewModel.RecipesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipebookTheme {
                val viewModel: RecipesViewModel = viewModel()
                val navController = rememberNavController()
                NavHost(navController, startDestination = Screen.Main.route) {
                    composable(
                        route = Screen.Main.route, content =
                            {
                                MainScreen(
                                    viewModel,
                                    navController,
                                    modifier = Modifier.Companion
                                )
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
    }
}