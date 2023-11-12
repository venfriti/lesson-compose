package com.example.datastructures.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Lesson(
    val day: Int,
    @StringRes val title : Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)
