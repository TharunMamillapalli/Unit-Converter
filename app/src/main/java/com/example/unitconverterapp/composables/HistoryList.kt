package com.example.unitconverterapp.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.unitconverterapp.data.ConversionResult

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    onCloseTask:(ConversionResult)->Unit,
    modifier: Modifier=Modifier
){
    LazyColumn {
        itemsIndexed(list.value){index,item->
            HistoryItem(messagePart1 = item.messagePart1,
                messagePart2 = item.messagePart2,
                onClose = {onCloseTask(item)}
                )
        }
    }
}