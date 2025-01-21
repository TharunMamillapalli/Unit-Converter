package com.example.unitconverterapp.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.unitconverterapp.composables.converter.ConversionMenu
import com.example.unitconverterapp.composables.converter.InputBlock
import com.example.unitconverterapp.composables.converter.ResultBlock
import com.example.unitconverterapp.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion:MutableState<Conversion?>,
    inputText:MutableState<String>,
    typedValue:MutableState<String>,
    isLandScape:Boolean,
    save:(String,String)->Unit
){
    var toSave by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


        ConversionMenu(list = list, isLandScape) {
            selectedConversion.value = it
            typedValue.value = "0.0"

        }
        selectedConversion.value?.let {
            InputBlock(conversion = it, inputText = inputText, isLandScape) { input ->
                typedValue.value = input
                toSave = true

            }
        }
        if (typedValue.value != "0.0") {
            val input = typedValue.value.toDouble()
            val multiply = selectedConversion.value!!.multiplyBy
            val result = input * multiply

            //rouding off the result to 4 decimal places
            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.DOWN
            val roundedResult = df.format(result)

            val message1 =
                "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
            val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
            if (toSave) {
                save(message1, message2)
                toSave = false
            }

            ResultBlock(
                message1 = message1,
                messsage2 = message2
            )
        }
    }

}