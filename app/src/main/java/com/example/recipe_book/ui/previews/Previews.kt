package com.example.recipe_book.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipe_book.data.model.ProductResponse
import com.example.recipe_book.data.model.Recipe
import com.example.recipe_book.ui.components.ActionButton
import com.example.recipe_book.ui.components.Topbar
import com.example.recipe_book.ui.screens.MainScreenContent
import com.example.recipe_book.ui.theme.RecipebookTheme

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


@Preview(showBackground = true)
@Composable
fun TopbarPreview() {
    RecipebookTheme {
        Topbar(onHomeClick = {}, onSearchClick = {})
    }
}

@Preview
@Composable
fun ActionButtonPreview() {
    RecipebookTheme {
        ActionButton(onClick = {})
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    RecipebookTheme {
        // Call the stateless Content version directly
        MainScreenContent(
            recipesState = mockData,
            modifier = Modifier
        )
    }
}


