package com.example.recipe_book.ui.components

import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun ActionButton(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = onClick
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add")
        Text("Add Recipe", fontSize = 20.sp)
    }
}