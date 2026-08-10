package com.example.recipe_book.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val data: List<Recipe>
)

@Serializable
data class Recipe(
    val name: String,
    val ingredients: Map<String, String>,
    val steps: List<String>,
    val notes: String,
    val picture: String = "" //Platzhalter
)