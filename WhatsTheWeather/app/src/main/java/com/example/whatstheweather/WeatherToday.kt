package com.example.whatstheweather

// WeatherToday.kt
data class WeatherToday(
    val location: Location,
    val current: Current
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double
)

data class Current(
    val temp_c: Double,
    val temp_f: Double,
    val condition: Condition,
    val humidity: Int,
    val wind_mph: Double,
    val wind_kph: Double
)

data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)
