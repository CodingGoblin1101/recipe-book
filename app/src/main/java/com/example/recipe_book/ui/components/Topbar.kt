package com.example.recipe_book.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.recipe_book.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(onHomeClick: () -> Unit, onSearchClick: () -> Unit) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.recipe_banner),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
        )
        TopAppBar(
            title = { Text("Recipe Book") },
            navigationIcon =
                {
                    Row {
                        IconButton(
                            onClick = onHomeClick,
                            shape = ButtonDefaults.outlinedShape,
                        ) {
                            Icon(Icons.Filled.Home, contentDescription = "Home")
                        }
                        IconButton(
                            onClick = onSearchClick,
                            shape = ButtonDefaults.outlinedShape,
                        ) {
                            Icon(Icons.Filled.Search, contentDescription = "Search")
                        }
                    }
                }
        )
    }
}