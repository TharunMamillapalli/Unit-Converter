package com.example.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.unitconverterapp.composables.BaseScreen
import com.example.unitconverterapp.data.ConverterDataBase
import com.example.unitconverterapp.data.ConverterRepositoryImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao= ConverterDataBase.getInstance(applicationContext).converterDAO
        val repository=ConverterRepositoryImpl(dao)
        val factory=ConverterViewModelFactory(repository)
        setContent {
            BaseScreen(factory)


        }
    }
}



