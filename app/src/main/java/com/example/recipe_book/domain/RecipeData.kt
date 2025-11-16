package com.example.recipe_book.domain

import com.google.api.services.sheets.v4.Sheets
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class Recipe(
    val name: String,
    val id: Int,
    val ingredients: List<String>,
    val description: String,
    val tags: List<String>
)

class RecipeData(){
    fun updateRecipeData(){

    }
    suspend fun readRecipesFromSheet(
        sheets: Sheets,
        spreadsheetId: String = "abcdefg1234567890"
    ): List<List<String>> = withContext(Dispatchers.IO) {

        val response = sheets.spreadsheets().values()
            .get(spreadsheetId, "recipes!A1:F")
            .execute()

        val values = response.getValues()

        if (values == null || values.isEmpty()) emptyList()
        else values.map { row -> row.map { it.toString() } }
    }

}