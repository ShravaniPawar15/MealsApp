package com.example.model.di

import android.content.Context
import androidx.room.Room
import com.example.model.api.MealsWebService
import com.example.model.db.MealDatabase
import com.example.model.db.MealsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class )
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideMealsDao(mealDatabase: MealDatabase): MealsDao
    = mealDatabase.mealsDao()

    @Singleton
    @Provides
    fun provideMealsWebService(): MealsWebService = MealsWebService()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): MealDatabase
    = Room.databaseBuilder(
        context,
        MealDatabase::class.java,
        "meal_db")
        .fallbackToDestructiveMigration()
        .build()
}