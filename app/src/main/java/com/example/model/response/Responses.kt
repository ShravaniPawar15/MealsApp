package com.example.model.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MealsCategoryResponse(val categories: List<MealResponse>)

@Entity(tableName = "meal_category_tbl")
data class MealResponse(
    @PrimaryKey
    @SerializedName("idCategory")
    val id: String,

    @ColumnInfo(name = "name")
    @SerializedName("strCategory")
    val name: String,

    @ColumnInfo(name = "description")
    @SerializedName("strCategoryDescription")
    val description: String,

    @ColumnInfo(name = "imageUrl")
    @SerializedName("strCategoryThumb")
    val imageUrl: String
)