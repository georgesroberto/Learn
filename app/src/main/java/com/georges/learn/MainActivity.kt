package com.georges.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.georges.learn.ui.theme.LearnTheme
import com.georges.learn.courses

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTheme {

            }
        }
    }
}


@Composable
fun CourseCard() {
    Card {
        Row {
            Image(
                painter = painterResource(R.drawable.architecture),
                contentDescription = "Course Name"
            )
            courseDescription()
        }
    }
}

@Composable
fun courseDescription(){
    Column(
        modifier = Modifier.padding(16.dp)
    ){
        Text(text = "Course Name")
        Row {
            Image(painter = painterResource(R.drawable.ic_grain), contentDescription = "Decorator")
            Text(text = "100")
        }
    }
}