package com.example.whatstheweather

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.Scanner
// WeatherRepository.kt
class WeatherRepository {

    suspend fun getCurrentWeather(city: String): WeatherToday? {
        val response = RetrofitClient.instance.getCurrentWeather(city)
        if (response.isSuccessful) {
            // If the request is successful, return the body (WeatherToday data)
            return response.body()
        } else {
            // If the request fails, log or handle the error as needed
            throw Exception("Failed to fetch weather data: ${response.code()}")
        }
    }
}





