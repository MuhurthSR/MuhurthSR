package com.example.calculator1

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder


class CalculatorViewModel : ViewModel() {
    private val _input = mutableStateOf("")
    private val _result = mutableStateOf("")
    private val _diaplay = mutableStateOf("")

    val input: MutableState<String>
        get() = _input

    val result: MutableState<String>
        get() = _result
    val display: MutableState<String>
        get() = _diaplay

    fun onClickAC(){
        _input.value=""
        _result.value=""
        _diaplay.value = ""
    }
    fun onCLick(string: String){
        _input.value+=string
        _diaplay.value +=string
    }
    fun onBack(){
        _input.value = _input.value.dropLast(1)
        _diaplay.value = _diaplay.value.dropLast(1)
    }

    fun onClickMuitiply(){
        _input.value+="*"
        _diaplay.value += "x"
    }

    fun calculateResult() {
        try {
            val exp = ExpressionBuilder(input.value).build()
            val calculationResult = exp.evaluate()
            val resultString = if (calculationResult.isInteger()) {
                calculationResult.toInt().toString()
            } else {
                calculationResult.toString()
            }
            _result.value = resultString
        } catch (e: Exception) {
            _result.value = ""
        }
    }

    private fun Double.isInteger(): Boolean {
        return this == this.toInt().toDouble()
    }


}