package com.example.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

interface ConverterRepository {
    suspend fun insertResult(result:ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun updateResult(result: ConversionResult)
    suspend fun deleteAllResults()
    fun getSavedResults():Flow<List<ConversionResult>>

}