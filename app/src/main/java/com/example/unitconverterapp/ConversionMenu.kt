package com.example.unitconverterapp



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@Composable
fun ConversionMenu(list: List<Conversion>,modifier: Modifier=Modifier,convert:(Conversion)->Unit) {
    var displayingText by remember{ mutableStateOf("Select the Conversion type") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    val icon=if(expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    OutlinedTextField(
        value = displayingText, onValueChange ={displayingText=it},
        textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.fillMaxWidth()
            .onGloballyPositioned {cordinates->
                textFieldSize=cordinates.size.toSize()
            },
        label = { Text(text = "Conversion Type") },
        trailingIcon = {
            Icon(icon, contentDescription = "icon",
            modifier.clickable { expanded=!expanded })
        },
        readOnly = true
        )
    DropdownMenu(
        expanded=expanded, onDismissRequest = {expanded=false},
        modifier=modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})
    ) {
        list.forEach {conversion ->
            DropdownMenuItem(
                onClick = {
                    expanded=false
                    displayingText=conversion.description
                    convert(conversion)
                },
                text={ Text(text = conversion.description) }
            )

        }
    }

}