package com.example.recipe_book.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipe_book.domain.Recipe
import com.example.recipe_book.domain.RecipeData
import com.example.recipe_book.repository.Repository

class RecipeViewModel : ViewModel() {
    private val _repository: LiveData<List<Recipe>> = Repository().getRecipeData()
    val repository: MutableLiveData<List<Recipe>> = _repository

    init {

    }

}
