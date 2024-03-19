package com.georges.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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


@Composable
fun SpaceApp() {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Art Title")
            Text(text = "Artist")
        }

        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        ){
            Button(onClick = { /*TODO*/ }) {

            }
            Button(onClick = { /*TODO*/ }) {

            }
        }
    }
}
