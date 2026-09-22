package com.example.recipe_book.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.recipe_book.ui.theme.RecipebookTheme


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    RecipebookTheme {
        MainScreen(
            viewModel(),
            navController,
            Modifier
        )
    }
}
