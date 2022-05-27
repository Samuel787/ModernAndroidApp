package com.example.modernandroidapp.di

import com.example.modernandroidapp.model.CountriesService
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    fun providesCountriesService(): CountriesService {
        return CountriesService()
    }

}