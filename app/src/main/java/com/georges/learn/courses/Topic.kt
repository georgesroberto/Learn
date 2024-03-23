package com.georges.learn.courses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Courses(
    @DrawableRes val imageResourceId: Int,
    @StringRes val courseNameStringId: Int,
    val numberTopics: Int
)
