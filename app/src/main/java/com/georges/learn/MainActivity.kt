package com.georges.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.georges.learn.ui.RaceTrackerApp
import com.georges.learn.ui.theme.LearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTheme {
                // A surface container using the 'background' color from the theme
                RaceTrackerApp()
            }
        }
    }
}
