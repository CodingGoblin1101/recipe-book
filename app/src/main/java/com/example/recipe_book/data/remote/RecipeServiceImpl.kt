package com.example.recipe_book.data.remote

import android.util.Log
import com.example.recipe_book.data.model.ProductResponse
import com.example.recipe_book.data.model.Recipe
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
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
                contentType(io.ktor.http.ContentType.Application.Json)
                setBody(recipe)
            } as HttpResponse
            response.setStatusCode(200)
        } catch (e: Exception) {
            false
        } as Boolean
    }
}