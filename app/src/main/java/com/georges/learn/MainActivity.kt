package com.georges.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.georges.learn.model.Affirm
import com.georges.learn.ui.theme.LearnTheme
import com.georges.learn.data.Datasource

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
                    AffirmApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AffirmApp() {
    AffirmList(affirmList = Datasource().loadAffirmations())
}

@Composable
fun AffirmationCard(affirm: Affirm, modifier: Modifier = Modifier){
    Card (
        modifier = modifier
    ){
        Column {
            Image(
                painter = painterResource(affirm.imageResourceId),
                contentDescription = stringResource(affirm.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(196.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirm.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
@Composable
fun AffirmList(affirmList: List<Affirm>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier){
        items(affirmList){
            affirmation -> AffirmationCard(
                affirm = affirmation,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}