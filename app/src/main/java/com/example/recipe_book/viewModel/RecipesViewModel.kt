package com.example.recipe_book.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_book.data.model.ProductResponse
import com.example.recipe_book.data.model.Recipe
import com.example.recipe_book.data.remote.RecipeService
import kotlinx.coroutines.launch

class RecipesViewModel : ViewModel() {
    private val service = RecipeService.create()

    // LiveData = tied to Android livecycle, StateFlow isn't
    private val _recipeState = MutableLiveData<ProductResponse?>(null)
    val recipesState: LiveData<ProductResponse?> = _recipeState

    init {
        fetchRecipes()
    }

    fun fetchRecipes() {
        viewModelScope.launch {
            try {
                val response = service.getProducts()
                _recipeState.value = response
            } catch (e: Exception) {
                //TODO: Handle error
                _recipeState.value = ProductResponse(emptyList())
            }
        }
    }

    //TODO: addRecipes
    fun addRecipes(recipe: Recipe) {
        viewModelScope.launch {
            try {
                // something
                val request = service.postProduct(recipe)
                if (request) {
                    // refreshes the list
                    fetchRecipes()
                } else {
                    //TODO: Handle failure request
                }
            } catch (e: Exception) {
                //TODO: Handle error
                _recipeState.value = ProductResponse(emptyList())
            }
        }
    }

}