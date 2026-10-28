package com.example.recipe_book.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipe_book.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onHomeClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    // Use a Surface to provide background and elevation similar to a TopAppBar
    Surface(
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 3.dp
    ) {
        Column(
            modifier = Modifier
                .windowInsetsPadding(TopAppBarDefaults.windowInsets) // Respect the status bar -> prevents searchbar to be hidden behind systembar
        ) {
            Image(
                painter = painterResource(id = R.drawable.recipe_banner),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
            )
            TopAppBar(
                windowInsets = TopAppBarDefaults.windowInsets,
                title = {

                },
                navigationIcon =
                    {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 8.dp)
                        ) {
                            IconButton(
                                onClick = onHomeClick,
                                shape = ButtonDefaults.outlinedShape,
                                modifier = Modifier.padding(end = 4.dp)
                            ) {
                                Icon(Icons.Filled.Home, contentDescription = "Home")
                            }
                            Icon(Icons.Filled.Search, contentDescription = "Search")

                            SimpleSearchBar(
                                textFieldState = TextFieldState(),
                                onSearch = {},
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
            )
        }
    }
}