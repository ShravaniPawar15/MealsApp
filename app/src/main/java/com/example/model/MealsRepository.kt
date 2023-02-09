package com.example.model

import android.content.Context
import com.example.model.api.MealsWebService
import com.example.model.db.MealDatabase
import com.example.model.db.MealsDao
import com.example.model.response.MealResponse
import com.example.model.response.MealsCategoryResponse
import com.util.MyUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject


class MealsRepository @Inject constructor(@ApplicationContext private val applicationContext: Context,private val webService: MealsWebService,
                                          private val mealsDao: MealsDao?

) {
    private var cachedMeals = listOf<MealResponse>()
    suspend fun getMeals(): List<MealResponse>? {

        if (MyUtils.isInternetAvailable(applicationContext)) {
            val response = webService.getMeals()
            cachedMeals = response.categories
            mealsDao?.addMeals(cachedMeals)
            return response.categories
        }else{
            return mealsDao?.getMeals()
        }


        }
        suspend fun getMealsDb(): List<MealResponse> = mealsDao?.getMeals()!!
        fun getMeal(id: String): MealResponse? {
            return cachedMeals.firstOrNull {
                it.id == id
            }

        }
//    companion object{
//        @Volatile
//        private var instance: MealsRepository? = null
//        fun getInstance() = instance?: synchronized(this){
//
//            instance ?: MealsRepository().also { instance = it }
//        }
//    }
    }