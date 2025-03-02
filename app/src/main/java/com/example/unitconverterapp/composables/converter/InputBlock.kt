package com.example.unitconverterapp.composables.converter

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverterapp.data.Conversion

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBlock(
    conversion: Conversion,
    inputText:MutableState<String>,
    isLandScape:Boolean,
    modifier: Modifier=Modifier,
    context: Context = LocalContext.current,
    caluculate:(String)->Unit
){
    if(isLandScape) {
        Column(
            modifier = modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
            Row(
                modifier = modifier

            ) {
                TextField(
                    value = inputText.value,
                    onValueChange = {
                        inputText.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Number
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)
                    ),
                    textStyle = TextStyle(color = Color.DarkGray, fontSize = 30.sp)
                )
                Text(
                    text = conversion.convertFrom,
                    fontSize = 24.sp,
                    modifier = modifier
                        .padding(10.dp, 20.dp, 0.dp, 0.dp)

                )

            }
            Spacer(modifier = modifier.height(20.dp))
            OutlinedButton(
                onClick = {
                    if (inputText.value != "") {
                        caluculate(inputText.value)
                    } else
                        Toast.makeText(context, "Please enter your value", Toast.LENGTH_LONG).show()

                }
            ) {
                Text(
                    text = "convert",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
        }
    }
    else{
        Column(
            modifier = modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                TextField(
                    value = inputText.value,
                    onValueChange = {
                        inputText.value = it
                    },
                    modifier = modifier
                        .fillMaxWidth(0.65f),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Number
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)
                    ),
                    textStyle = TextStyle(color = Color.DarkGray, fontSize = 30.sp)
                )
                Text(
                    text = conversion.convertFrom,
                    fontSize = 24.sp,
                    modifier = modifier
                        .padding(10.dp, 20.dp, 0.dp, 0.dp)
                        .fillMaxWidth(0.35f)
                )

            }
            Spacer(modifier = modifier.height(20.dp))
            OutlinedButton(
                onClick = {
                    if (inputText.value != "") {
                        caluculate(inputText.value)
                    } else
                        Toast.makeText(context, "Please enter your value", Toast.LENGTH_LONG).show()

                },
                modifier = modifier.fillMaxWidth(1F)
            ) {
                Text(
                    text = "convert",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
        }
    }
}