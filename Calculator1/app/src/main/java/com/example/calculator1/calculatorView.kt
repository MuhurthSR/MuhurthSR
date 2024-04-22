package com.example.calculator1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CalculatorView(viewModel: CalculatorViewModel){

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0, 0, 0))
        ,

        contentAlignment = Alignment.BottomCenter
    ){


        Column (
            modifier = Modifier
                .padding(10.dp)
                .padding(bottom = 16.dp)
            ,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            
            Text(text = viewModel.display.value, modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .fillMaxHeight(0.2f),
                color = Color.White,
                maxLines = 2,
                minLines = 2,
                textAlign = TextAlign.End,
                fontSize = 40.sp
                )
            Text(text = viewModel.result.value, modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .fillMaxHeight(0.2f),
                color = Color.White,
                maxLines = 2,
                minLines = 2,
                textAlign = TextAlign.End,
                fontSize = 25.sp
            )

            Row (
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                ){
                Button(
                    onClick = {viewModel.onClickAC() },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,186,185))


                ) {
                    Text(text = "AC", fontSize = 16.sp, modifier = Modifier.fillMaxWidth())

                }
                Button(
                    onClick = { viewModel.onCLick("%") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,186,185))

                ) {
                    Text(text = "%", fontSize = 25.sp)
                }
                Button(
                    onClick = { viewModel.onBack() },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,186,185))

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Custom Button"
                    )

                }
                Button(
                    onClick = { viewModel.onCLick("/") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,186,185))

                ) {
                    Text(text = "\u00F7", fontSize = 30.sp)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row (
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = {viewModel.onCLick("7") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))


                ) {
                    Text(text = "7", fontSize = 24.sp)
                }
                Button(
                    onClick = { viewModel.onCLick("8") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))

                ) {
                    Text(text = "8", fontSize = 24.sp)
                }
                Button(
                    onClick = { viewModel.onCLick("9") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))

                ) {
                    Text(text = "9", fontSize = 24.sp)
                }
                Button(
                    onClick = { viewModel.onClickMuitiply() },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,186,185))

                ) {
                    Text(text = "X", fontSize = 20.sp)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row (
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = { viewModel.onCLick("4")},
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))


                ) {
                    Text(text = "4", fontSize = 24.sp)

                }
                Button(
                    onClick = { viewModel.onCLick("5") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))

                ) {
                    Text(text = "5", fontSize = 24.sp)

                }
                Button(
                    onClick = {viewModel.onCLick("6") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))

                ) {
                    Text(text = "6", fontSize = 24.sp)

                }
                Button(
                    onClick = { viewModel.onCLick("-") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,186,185))

                ) {
                    Text(text = "-", fontSize = 38.sp)

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row (
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = { viewModel.onCLick("1") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))
                ) {
                    Text(text = "1", fontSize = 24.sp)

                }
                Button(
                    onClick = { viewModel.onCLick("2") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))

                ) {
                    Text(text = "2", fontSize = 24.sp)

                }
                Button(
                    onClick = { viewModel.onCLick("3") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))

                ) {
                    Text(text = "3", fontSize = 24.sp)

                }
                Button(
                    onClick = { viewModel.onCLick("+") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,186,185))

                ) {
                    Text(text = "+", fontSize = 24.sp)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row (
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = { viewModel.onCLick("00") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))


                ) {
                    Text(text = "00", fontSize = 19.sp)

                }
                Button(
                    onClick = { viewModel.onCLick("0") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))

                ) {
                    Text(text = "0", fontSize = 24.sp)

                }
                Button(
                    onClick = { viewModel.onCLick(".") },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,124,124))

                ) {
                    Text(text = ".", fontSize = 40.sp)

                }
                Button(
                    onClick = { viewModel.calculateResult() },
                    Modifier.size(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0,186,185))

                ) {
                    Text(text = "=", fontSize = 24.sp)

                }
            }
            Spacer(modifier = Modifier.height(10.dp))



        }
    }

}


@Preview
@Composable
fun CalculatorViewPreview(){
    val viewModel = CalculatorViewModel()
    CalculatorView (viewModel = viewModel)
}