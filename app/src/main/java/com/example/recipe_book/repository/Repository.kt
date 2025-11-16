package com.example.recipe_book.repository

import android.content.Context
import com.example.recipe_book.domain.Recipe
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.sheets.v4.Sheets


class Repository {
    fun getRecipeData(){

    }

    fun loadCredentials(context: Context): GoogleCredential {
        val stream = context.assets.open("service-account.json")

        return GoogleCredential.fromStream(stream)
            .createScoped(
                listOf(
                    "https://www.googleapis.com/auth/drive",
                    "https://www.googleapis.com/auth/spreadsheets"
                )
            )
    }
    fun provideSheetsService(context: Context): Sheets {
        val credential = loadCredentials(context)

        return Sheets.Builder(
            NetHttpTransport(),
            JsonFactory.getDefaultInstance(),
            credential
        )
            .setApplicationName("RecipeApp")
            .build()
    }

    fun provideDriveService(context: Context): Drive {
        val credential = loadCredentials(context)

        return Drive.Builder(
            NetHttpTransport(),
            JsonFactory.getDefaultInstance(),
            credential
        )
            .setApplicationName("RecipeApp")
            .build()
    }


}