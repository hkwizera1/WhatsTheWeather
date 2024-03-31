package com.example.whatstheweather

//ServiceInterface.kt

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface serviceInterface {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("q") query: String
    ): Response<WeatherToday>
}




