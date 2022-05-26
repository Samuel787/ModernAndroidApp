package com.example.modernandroidapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modernandroidapp.model.Country

class ListViewModel: ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        val mockData = listOf<Country>(
            Country("CountryA"),
            Country("CountryA")
        )

        countryLoadError.value = false
        loading.value = false
        countries.value = mockData
    }

}