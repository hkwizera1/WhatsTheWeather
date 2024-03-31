package com.example.whatstheweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// WeatherTodayView.kt

class WeatherTodayView(private val repository: WeatherRepository) : ViewModel() {
    private val _weatherToday = MutableLiveData<WeatherToday?>()
    val weatherToday: LiveData<WeatherToday?> = _weatherToday

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun fetchCurrentWeather(city: String) {
        viewModelScope.launch {
            try {
                val weatherResponse = repository.getCurrentWeather(city)
                if (weatherResponse != null) {
                    _weatherToday.postValue(weatherResponse)
                    _error.postValue(null) // Clear any previous error
                } else {
                    // Handle null response as an error condition
                    _error.postValue("Failed to fetch weather data.")
                }
            } catch (e: Exception) {
                // Post exception message to error LiveData
                _error.postValue(e.message ?: "An unknown error occurred")
            }
        }
    }
}

