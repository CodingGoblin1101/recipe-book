package com.example.recipe_book.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_book.data.model.ProductResponse
import com.example.recipe_book.data.remote.RecipeService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipesViewModel : ViewModel() {
    private val service = RecipeService.create()

    // LiveData can be used too
    // LiveData = tied to Android livecycle, StateFlow isn't
    private val _recipeState = MutableStateFlow<ProductResponse?>(null)
    val recipesState: StateFlow<ProductResponse?> = _recipeState.asStateFlow()

    init {
        fetchRecipes()
    }

    fun fetchRecipes(){
        viewModelScope.launch {
            try {
                val response = service.getProducts()
                _recipeState.value = response
            } catch (e: Exception){
                _recipeState.value = ProductResponse(emptyList())
            }
        }
    }
}