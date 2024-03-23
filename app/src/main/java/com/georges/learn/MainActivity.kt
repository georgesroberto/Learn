package com.georges.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.georges.learn.courses.Courses
import com.georges.learn.data.Datasource
import com.georges.learn.ui.theme.LearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTheme {
               CourseApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseApp(){
    CourseList(coursesList = Datasource().loadCourses())
}

@Composable
fun CourseCard(courses: Courses, modifier: Modifier = Modifier) {
    Card(
        modifier.padding(8.dp)
    ) {
        Row {
            Image(
                painter = painterResource(courses.imageResourceId),
                contentDescription = stringResource(courses.courseNameStringId)
            )
            Column{
                Text(
                    text = stringResource(courses.courseNameStringId),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp),
                )
                Row (
                    modifier = Modifier.padding(start = 16.dp),
                ){
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = stringResource(R.string.app_name),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = "${ courses.numberTopics }")
                }
            }
        }
    }
}


@Composable
fun CourseList(coursesList: List<Courses>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(coursesList){course ->
            CourseCard(courses = course)
        }
    }
}