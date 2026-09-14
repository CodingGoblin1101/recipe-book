package com.example.recipe_book.data.remote

import android.util.Log
import com.example.recipe_book.data.model.ProductResponse
import com.example.recipe_book.data.model.Recipe
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json

class RecipeServiceImpl(private val client: HttpClient) : RecipeService {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    override suspend fun getProducts(): ProductResponse {
        val response = client.get(HttpRoute.URL)
        val rawJson = response.bodyAsText()
        Log.d("ProductServiceImpl", "Raw JSON: $rawJson")
        return json.decodeFromString(rawJson)
    }

    override suspend fun postProduct(recipe: Recipe): Boolean {
        return try {
            val response: HttpResponse = client.post(HttpRoute.URL) {
                contentType(ContentType.Application.Json)
                setBody(recipe)
            }
            // Google Script returns 200 after the redirect is finished
            response.status.value in 200..299 || response.status.value == 302
        } catch (e: Exception) {
            Log.e("RecipeService", "Error posting recipe", e)
            false
        }
    }
}