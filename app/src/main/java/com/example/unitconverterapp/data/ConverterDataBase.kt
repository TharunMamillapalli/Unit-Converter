package com.example.unitconverterapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ConversionResult::class], version = 1)
abstract class ConverterDataBase:RoomDatabase() {

    abstract val converterDAO: ConverterDAO

}