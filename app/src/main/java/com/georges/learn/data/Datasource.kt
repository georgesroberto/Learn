package com.georges.learn.data

import com.georges.learn.R
import com.georges.learn.courses.Courses

class Datasource{
    fun loadCourses(): List<Courses>{
        return listOf<Courses>(
            Courses(R.drawable.automotive, R.string.architecture, 100),
            Courses(R.drawable.architecture, R.string.architecture, 100),
            Courses(R.drawable.biology, R.string.app_name, 100),
            Courses(R.drawable.crafts,R.string.crafts,100),
            Courses(R.drawable.culinary, R.string.culinary, 100),
            Courses(R.drawable.business, R.string.business, 100),
            Courses(R.drawable.design,R.string.design, 100),
            Courses(R.drawable.drawing, R.string.drawing, 100),
            Courses(R.drawable.engineering, R.string.app_name, 100),
            Courses(R.drawable.fashion, R.string.app_name, 100),
            Courses(R.drawable.finance, R.string.app_name, 100),
            Courses(R.drawable.gaming, R.string.app_name, 100),
            Courses(R.drawable.geology, R.string.app_name, 100),
            Courses(R.drawable.history, R.string.app_name, 100),
            Courses(R.drawable.journalism, R.string.app_name, 100),
            Courses(R.drawable.law, R.string.app_name, 100),
            Courses(R.drawable.lifestyle, R.string.app_name, 100),
            Courses(R.drawable.music, R.string.app_name, 100),
            Courses(R.drawable.physics, R.string.app_name, 100),
            Courses(R.drawable.painting, R.string.app_name, 100),
            Courses(R.drawable.photography, R.string.app_name, 100),
            Courses(R.drawable.tech, R.string.app_name, 100),
            Courses(R.drawable.film, R.string.app_name, 100)
        )
    }
}