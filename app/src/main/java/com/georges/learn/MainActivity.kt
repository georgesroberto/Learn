package com.georges.learn


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.georges.learn.ui.theme.LearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SpaceApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpaceApp() {
    var index by remember { mutableIntStateOf(1) }
    val imageUrl = when (index){
        1 -> painterResource(R.drawable.image1)
        2 -> painterResource(R.drawable.image2)
        3 -> painterResource(R.drawable.image3)
        4 -> painterResource(R.drawable.image4)
        else -> painterResource(R.drawable.image1)
    }
    val title = when (index){
        1 -> R.string.image1_title
        2 -> R.string.image2_title
        3 -> R.string.image3_title
        4 -> R.string.image4_author
        else -> R.string.image1_title
    }
    val author= when (index){
        1 ->R.string.image1_author
        2 ->R.string.image2_author
        3 ->R.string.image3_title
        4 ->R.string.image4_author
        else -> R.string.image1_title
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        Spacer(modifier = Modifier.padding(20.dp))

        Image(
            painter = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(.9f)
                .fillMaxHeight(.6f)
                .align(Alignment.CenterHorizontally)
                .border(
                    width = 6.dp,
                    color = Color.Blue
                )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .background(color = Color.LightGray)
        ) {
            EditTitle(title = title)
            EditAuthor(author = author, 2024)
        }

        Spacer(modifier = Modifier.padding(14.dp))

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(.8f)
        ){
            Button(
                onClick = {
                    if (index < 3){
                        index += 1
                    } else {
                        index = 1
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    if (index > 1){
                        index -= 1
                    } else {
                        index = 3
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun EditTitle(@StringRes title: Int){
    Text(
        stringResource(title),
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
    )
}

@Composable
fun EditAuthor(@StringRes author: Int, year:Int){
    Text(
        text = stringResource(author, year),
        modifier = Modifier
            .padding(10.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
}
