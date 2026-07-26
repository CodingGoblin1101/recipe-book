package com.example.recipe_book.data

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val data: List<Product>
)

@Serializable
data class Product(
    val name: String ,
    val ingredients: String ,
    val steps: String ,
    val alternatives: String ,
    val pictures: String = "" //Platzhalter
)