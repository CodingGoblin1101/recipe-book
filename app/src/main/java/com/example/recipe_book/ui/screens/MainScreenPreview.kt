package com.example.recipe_book.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipe_book.data.model.ProductResponse
import com.example.recipe_book.data.model.Recipe
import com.example.recipe_book.ui.components.RecipeApp
import com.example.recipe_book.ui.theme.RecipebookTheme
@Preview(showBackground = true)
@Composable
fun RecipeAppPreview() {
    RecipebookTheme {
        RecipeApp()
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    // Create mock data for the preview
    val mockData = ProductResponse(
        data = listOf(
            Recipe(
                name = "Pasta Carbonara",
                ingredients = mapOf("Spaghetti" to "200g", "Eggs" to "2", "Pancetta" to "100g"),
                steps = listOf("Boil water", "Fry pancetta", "Mix everything"),
                notes = "Add lots of pepper",
                pictures = ""
            ),
            Recipe(
                name = "Omelette",
                ingredients = mapOf("Eggs" to "3", "Milk" to "50ml"),
                steps = listOf("Whisk eggs", "Pour into pan"),
                notes = "Don't overcook",
                pictures = ""
            )
        )
    )

    RecipebookTheme {
        // Call the stateless Content version directly
        MainScreenContent(
            recipesState = mockData,
            onAddRecipeClick = {},
            modifier = Modifier
        )
    }
}
