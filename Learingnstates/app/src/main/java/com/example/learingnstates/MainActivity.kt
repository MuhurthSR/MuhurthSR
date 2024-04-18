package com.example.learingnstates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.learingnstates.ui.theme.LearingnStatesTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearingnStatesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptionShip()
                }
            }
        }
    }
}
@Composable
fun CaptionShip(){

    val shipDirection = remember { mutableStateOf("NORTH") }
    val treasure = remember { mutableStateOf(0) }
    val storm = remember { mutableStateOf("") }

    Column {
        Text(text = "ADVENTURE", fontSize = 20.sp)
        Text(text = "Current Direction : ${shipDirection.value}")
        Text(text = "Treasures found : ${treasure.value}")
        Text(text = "${storm.value}")
        Row {
            Text(text = "Sail East : ")
            Button(onClick = { shipDirection.value="EAST"
                if(Random.nextBoolean()){
                    treasure.value+=1
                    storm.value="Treasure found"
                }
                else{
                    storm.value="Storm Ahead"
                }

            }) {
                Text(text = "SAIL EAST")
            }
        }
        Row {
            Text(text = "Sail West : ")
            Button(onClick = { shipDirection.value="WEST"
                if(Random.nextBoolean()){
                    treasure.value+=1
                    storm.value="Treasure found"
                }
                else{
                    storm.value="Storm Ahead"
                }
            }) {
                Text(text = "SAIL WEST")
            }
        }
        Row {
            Text(text = "Sail North : ")
            Button(onClick = { shipDirection.value="North"
                if(Random.nextBoolean()){
                    treasure.value+=1
                    storm.value="Treasure found"
                }
                else{
                    storm.value="Storm Ahead"
                }
            }) {
                Text(text = "SAIL NORTH")
            }
        }
        Row {
            Text(text = "Sail South : ")
            Button(onClick = { shipDirection.value="SOUTH"
                if(Random.nextBoolean()){
                    treasure.value+=1
                    storm.value="Treasure found"
                }
                else{
                    storm.value="Storm Ahead"
                }
            }) {
                Text(text = "SAIL SOUTH")
            }
        }
    }
}
