package com.georges.learn.courses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Courses(
    @DrawableRes val image: Int,
    @StringRes val courseName: Int,
    val numberTopics: Int
)
