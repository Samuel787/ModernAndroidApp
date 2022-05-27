package com.example.modernandroidapp.view
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modernandroidapp.R
import com.example.modernandroidapp.model.Country
import com.example.modernandroidapp.util.getProgressDrawable
import com.example.modernandroidapp.util.loadImage

class CountryListAdapter(var countries: ArrayList<Country>):  RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val imageView = view.findViewById<ImageView>(R.id.imageView)
        private val countryName = view.findViewById<TextView>(R.id.name)
        private val countryCapital = view.findViewById<TextView>(R.id.capital)
        private val progressDrawable = getProgressDrawable(view.context)
        fun bind(country: Country) {
            countryName.text = country.countryName
            countryCapital.text = country.capital
            imageView.loadImage(country.flag, progressDrawable)
        }
    }

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int) = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size
}