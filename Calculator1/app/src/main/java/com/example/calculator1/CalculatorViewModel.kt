package com.example.calculator1

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder


class CalculatorViewModel : ViewModel() {
    private val _input = mutableStateOf("")
    private val _result = mutableStateOf("")

    val input: MutableState<String>
        get() = _input

    val result: MutableState<String>
        get() = _result


    fun onClickAC(){
        _input.value=""
        _result.value=""
    }
    fun onCLick(string: String){
        _input.value+=string
    }
    fun onBack(){
        _input.value = _input.value.dropLast(1)
    }

    fun calculateResult() {
        try {
            val exp = ExpressionBuilder(input.value).build()
            val calculationResult = exp.evaluate()
            _result.value = calculationResult.toString()
        } catch (e: Exception) {
            _result.value = ""
        }
    }


}