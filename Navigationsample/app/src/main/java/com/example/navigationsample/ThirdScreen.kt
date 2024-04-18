package com.example.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController


@Composable
fun ThirdScreen(navigateToFirstScreen:()->Unit){

    
    Column (
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "This is the third screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = navigateToFirstScreen) {
            Text(text = "Navigate to first screen")
        }
    }
}

@Preview
@Composable
fun ThirdScreenPreview(){
    val navController = rememberNavController()
    ThirdScreen({})
}