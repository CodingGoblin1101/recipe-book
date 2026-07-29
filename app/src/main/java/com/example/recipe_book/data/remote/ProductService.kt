package com.example.recipe_book.data.remote


import com.example.recipe_book.data.model.ProductResponse
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun interface ProductService {

    suspend fun getProducts(): ProductResponse

    companion object {
        fun create(): ProductService {
            return ProductServiceImpl(
                client = HttpClient(CIO) {
                    followRedirects = true
                    install(ContentNegotiation) {
                        json(Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                            explicitNulls = false
                        }, contentType = ContentType.Any) // Accept any content type as JSON
                    }
                })
        }
    }
}