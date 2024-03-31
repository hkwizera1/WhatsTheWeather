package com.example.whatstheweather

import WeatherTodayViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider

class WeatherFragment : Fragment() {

    private lateinit var cityNameEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var temperatureTextView: TextView
    private lateinit var weatherConditionTextView: TextView
    private lateinit var humidityTextView: TextView
    // Initialize your ViewModel using the factory
    private val viewModel: WeatherTodayView by viewModels {
        WeatherTodayViewModelFactory(WeatherRepository())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityNameEditText = view.findViewById(R.id.etCityName) as AutoCompleteTextView
        searchButton = view.findViewById(R.id.btnSearch)
        temperatureTextView = view.findViewById(R.id.tvTemperature)
        humidityTextView = view.findViewById(R.id.tvHumidity)
        weatherConditionTextView = view.findViewById(R.id.tvWeatherCondition)
        val cities = resources.getStringArray(R.array.country_names)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, cities)
        (cityNameEditText as AutoCompleteTextView).setAdapter(adapter)
        (cityNameEditText as AutoCompleteTextView).threshold = 1  // Start showing suggestions after 1 character is typed.

        searchButton.setOnClickListener {
            val cityName = cityNameEditText.text.toString().trim()
            if (cityName.isNotEmpty()) {
                viewModel.fetchCurrentWeather(cityName)
            }
        }

        viewModel.weatherToday.observe(viewLifecycleOwner) { weatherToday ->
            weatherToday?.let {
                val weatherInfoText = getString(
                    R.string.weather_info,
                    it.current.temp_c.toString(),
                    it.current.condition.text
                )
                view.findViewById<TextView>(R.id.tvWeatherInfo).text = weatherInfoText
            }
        }
    }
}
