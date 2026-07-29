package com.example.recipe_book.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipe_book.data.model.ProductResponse
import com.example.recipe_book.ui.theme.PurpleGrey80

@Composable
fun RecipesColumn(products: State<ProductResponse?>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        items(products.value!!.data) { recipe ->

            Card(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = PurpleGrey80
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 20.dp,
                )
            ) {
                Text(text = recipe.name)
                Column(
                    Modifier.padding(10.dp)
                ) {

                    Text(text = "Zutaten: ${recipe.ingredients}")
                    Text(text = "HowTo: ${recipe.steps}")
                    Text(text = "Alternativ: ${recipe.alternatives}")
                    Text(text = "Pictures: ${recipe.pictures}")
                }

            }

        }

    }
}