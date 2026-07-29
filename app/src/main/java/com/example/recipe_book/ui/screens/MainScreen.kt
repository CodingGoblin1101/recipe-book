package com.example.recipe_book.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.recipe_book.data.model.ProductResponse
import com.example.recipe_book.data.remote.ProductService
import com.example.recipe_book.ui.components.RecipesColumn

@Composable
fun MainScreen(modifier: Modifier) {
    val service = remember { ProductService.create() }

    val products = produceState<ProductResponse?>(
        initialValue = null,
        producer = {
            value = try {
                service.getProducts()
            } catch (e: Exception) {
                ProductResponse(emptyList())
            }
        }

    )

    if (products.value == null) {
        Text("Loading...")
    } else {
        RecipesColumn(products)
    }
}