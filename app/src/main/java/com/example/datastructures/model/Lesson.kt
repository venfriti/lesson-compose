package com.example.datastructures.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Lesson(
    @StringRes val name : Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)
