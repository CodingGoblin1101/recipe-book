package com.example.recipe_book.domain


data class Recipe(
    val name: String,
    val id: Int,
    val ingredients: List<String>,
    val description: String,
    val tags: List<String>
)