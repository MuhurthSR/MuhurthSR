package com.example.counterviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterviewmodel.ui.theme.CounterViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val ViewModel : CounterViewModel = viewModel()
            CounterViewModelTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TheCounterApp(viewModel())
                }
            }
        }
    }
}

@Composable
fun TheCounterApp(viewModel: CounterViewModel){


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = "COUNT : ${viewModel.count.value}",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { viewModel.increment() }) {
                Text(text = "INCREMENT")
            }
            Button(onClick = { viewModel.decrement() }) {
                Text(text = "DECREMENT")
            }
        }
    }

}


@Preview
@Composable
fun TheCounterAppPreview(){
    TheCounterApp(viewModel())
}




