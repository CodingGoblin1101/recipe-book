package com.example.recipe_book.data.model

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object RecipeDetail : Screen("recipe") {
        fun createRoute(recipeId: Int): String {
            return "$this.route/$recipeId"
        }
    }

    object AddRecipe: Screen("addRecipe") {
        fun createRoute(recipeId: Int): String {
            //return "$this.route/$recipeId"
        return "addRecipe"}
        }
    }
