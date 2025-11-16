package com.example.recipe_book.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipe_book.ui.screens.MainScreen
import com.example.recipe_book.ui.theme.RecipebookTheme

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    RecipebookTheme {
        MainScreen(Modifier)
    }
}