package com.example.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.MealsRepository
import com.example.model.response.MealResponse
import com.example.model.response.MealsCategoryResponse
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MealsCategoriesViewModel @Inject constructor(private val repository: MealsRepository): ViewModel(){
//    = MealsRepository.getInstance()
    init {
        Log.d("TAG_COROUTINES", "we are about to launch a coroutine") //1
        viewModelScope.launch(Dispatchers.IO){
            Log.d("TAG_COROUTINES", "we have launched a coroutine") //3
            val meals = getMeals()
            Log.d("TAG_COROUTINES", "we have received the async data") //4

            if (meals != null) {
                mealsState.value = meals
            }
            else
            {
                mealsState.value= emptyList()
            }
        }
        Log.d("TAG_COROUTINES", "other work")   //2

    }

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    private suspend fun getMeals(): List<MealResponse>?{

            return repository.getMeals()


    }
}