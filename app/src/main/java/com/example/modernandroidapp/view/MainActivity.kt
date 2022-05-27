package com.example.modernandroidapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modernandroidapp.R
import com.example.modernandroidapp.databinding.ActivityMainBinding
import com.example.modernandroidapp.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val countriesAdapter = CountryListAdapter(arrayListOf())
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.countriesList.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = countriesAdapter
        }
        observeViewModel()
        setContentView(binding.root)
    }

    private fun observeViewModel() {
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                binding.countriesList.visibility = View.VISIBLE
                countriesAdapter.updateCountries(it)
            }
        })
        viewModel.countryLoadError.observe(this, Observer { isError ->
            Log.v("Samuel", "country load error: $isError")
            isError?.let {binding.listError.visibility = if(it) View.VISIBLE else View.GONE }
        })
        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                Log.v("Samuel", "loading: $isLoading")
                binding.loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.listError.visibility = View.GONE
                    binding.countriesList.visibility = View.GONE
                }
            }
        })
    }
}