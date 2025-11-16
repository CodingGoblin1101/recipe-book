package com.example.recipe_book.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipe_book.ui.screens.MainScreen
import com.example.recipe_book.ui.theme.RecipebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipebookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
fun Recipes(){

}

@Composable
fun Ingredients(){

    IngredientsContent()
}

@Composable
fun AddIngredients(onClick: () -> Unit ){
    Button(
        onClick = onClick,
    )
    {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Icon"
        )
    }
}

@Composable
fun IngredientsContent(){
    LazyRow {
        //items()

    }
}

