package com.example.recipe_book.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(onHomeClick: () -> Unit, onSearchClick: () -> Unit) {
    TopAppBar(
        title = { Text("Recipe Book") },
        navigationIcon = {
            Row{
                IconButton(
                    onClick = onHomeClick,
                    shape = ButtonDefaults.outlinedShape,
                ) {
                    Icon(Icons.Filled.Home, contentDescription = "Home")}
                IconButton(
                    onClick = onSearchClick,
                    shape = ButtonDefaults.outlinedShape,
                ) {
                    Icon(Icons.Filled.Search, contentDescription = "Search")}
            }
        }
    )

}