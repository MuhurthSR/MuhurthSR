package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){

    var inputValue by remember { mutableStateOf("")}
    var outputValue by remember { mutableStateOf("")}
    var inputUnit by remember { mutableStateOf("SELECT")}
    var outputUnit by remember { mutableStateOf("Meters")}
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.0) }
    val oconversionFactor = remember{ mutableStateOf(1.0) }

    fun convertUnits(){

        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oconversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "UNIT-CONVERTER", fontSize = 40.sp)
        OutlinedTextField(value = inputValue,
            onValueChange = {inputValue=it
                            convertUnits()},
            label = { Text(text = "Enter Value")} )
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Spacer(modifier = Modifier.width(10.dp))
            Box {
                //Input Box
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter")},
                        onClick = {
                            inputUnit = "Centimeter"
                            iExpanded = false
                            conversionFactor.value = 0.01
                            convertUnits()})
                    DropdownMenuItem(text = { Text(text = "Meter")},
                        onClick = {
                            inputUnit = "Meter"
                            iExpanded = false
                            conversionFactor.value = 1.0
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Feet")},
                        onClick = {
                            inputUnit = "Feet"
                            iExpanded = false
                            conversionFactor.value = 0.3048
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Millmeter")},
                        onClick = {
                            inputUnit = "Millmeter"
                            iExpanded = false
                            conversionFactor.value = 0.001
                            convertUnits()
                        })
                }
            }
            Spacer(modifier = Modifier.width(30.dp))
            Box {
                //Out box
                Button(onClick = { oExpanded = true }) {
                    Text(text = "SELECT")
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false}) {
                    DropdownMenuItem(text = { Text(text = "Centimeter")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeter"
                            oconversionFactor.value = 0.01
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Meter")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meter"
                            oconversionFactor.value = 1.0
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Feet")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            oconversionFactor.value = 0.3048
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Millmeter")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Millmeter"
                            oconversionFactor.value = 0.001
                            convertUnits()
                        })
                }

            }
            Spacer(modifier = Modifier.width(10.dp))

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "RESULT : ${outputValue} ${outputUnit}")

    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}