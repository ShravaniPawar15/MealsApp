package com.example.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.model.response.MealResponse

@Database(entities = [MealResponse::class], version = 1, exportSchema = false)
abstract class MealDatabase: RoomDatabase() {
    abstract fun mealsDao(): MealsDao
}