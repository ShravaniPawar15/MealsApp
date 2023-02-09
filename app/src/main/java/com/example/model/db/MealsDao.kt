package com.example.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.model.response.MealResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface MealsDao {
    @Upsert
    suspend fun addMeals(meals: List<MealResponse>)

    @Query("SELECT * from meal_category_tbl")
    suspend fun getMeals(): List<MealResponse>


}