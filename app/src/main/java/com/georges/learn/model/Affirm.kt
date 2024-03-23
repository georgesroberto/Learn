package com.georges.learn.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirm(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
