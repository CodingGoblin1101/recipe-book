package com.example.recipe_book.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.recipe_book.ui.components.RecipeApp
import com.example.recipe_book.ui.theme.RecipebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipebookTheme {
                RecipeApp()
            }
        }
    }
}