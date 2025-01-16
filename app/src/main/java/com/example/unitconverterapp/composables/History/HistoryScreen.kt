package com.example.unitconverterapp.composables.History

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.example.unitconverterapp.data.ConversionResult

@Composable
fun HistoryScreen(
    list: State<List<ConversionResult>>,
    modifier: Modifier=Modifier,
    onCloseTask:(ConversionResult)->Unit,
    onClearAllTask:()->Unit
){
    Column {
        if(list.value.isNotEmpty()) {
            Row(
                modifier = modifier.fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "History",
                    color = androidx.compose.ui.graphics.Color.Gray
                )
                OutlinedButton(onClick = { onClearAllTask() }) {
                    Text(
                        text = "Clear All",
                        color = androidx.compose.ui.graphics.Color.Gray
                    )
                }
            }
        }
        HistoryList(list, onCloseTask = {item->
            onCloseTask(item)

        })
    }

}