package com.example.modernandroidapp.di

import com.example.modernandroidapp.model.CountriesService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: CountriesService)
}