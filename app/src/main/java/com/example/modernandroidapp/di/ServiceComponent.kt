package com.example.modernandroidapp.di

import com.example.modernandroidapp.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ServiceModule::class])
interface ServiceComponent {
    fun inject(listViewModel: ListViewModel)
}