package com.example.recipe_book.data.model

import androidx.navigation.NavController

fun navigateToMainScreen(navController: NavController){
    navController.navigate(Screen.Main)
}

fun navigateToDetailsScreen (navController: NavController, recipeId: Int) {
    navController.navigate(Screen.RecipeDetail.createRoute(recipeId))
}

fun navigateToAddRecipeScreen(navController: NavController, recipeId: Int) {
    navController.navigate(Screen.AddRecipe.createRoute(recipeId))
}