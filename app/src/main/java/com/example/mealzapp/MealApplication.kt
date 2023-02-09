package com.example.mealzapp

import android.app.Application
import com.example.model.MealsRepository
import com.example.model.api.MealsWebService
import com.example.model.db.MealsDao
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MealApplication: Application() {
    lateinit var mealsRepository: MealsRepository
//    @Provides
//    override fun onCreate() {
//        super.onCreate()
//        //mealsRepository= MealsRepository(applicationContext, webService = MealsWebService(), null)
//    }
}