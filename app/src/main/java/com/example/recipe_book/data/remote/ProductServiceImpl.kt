package com.example.recipe_book.data.remote

import android.util.Log
import com.example.recipe_book.data.model.ProductResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class ProductServiceImpl(
    private val client: HttpClient
): ProductService {
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
}