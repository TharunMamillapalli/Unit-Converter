package com.example.unitconverterapp.di

import android.app.Application
import androidx.room.Room
import com.example.unitconverterapp.data.ConverterDataBase
import com.example.unitconverterapp.data.ConverterRepository
import com.example.unitconverterapp.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDatabase(app:Application):ConverterDataBase{
        return Room.databaseBuilder(
            app,
            ConverterDataBase::class.java,
            "converter_data_database"
        ).build()

    }

    @Provides
    @Singleton
    fun ConverterRepository(db:ConverterDataBase):ConverterRepository{
        return ConverterRepositoryImpl(db.converterDAO)
    }
}