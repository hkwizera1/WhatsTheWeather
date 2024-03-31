package com.example.whatstheweather
// RetrofitClient.kt
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object RetrofitClient {
    private const val BASE_URL = "https://api.weatherapi.com/v1/"
    private const val API_KEY = "f10c2f3aa7fe489bbe0234120242703"

    private val client: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(ApiKeyInterceptor())
    }.build()

    val instance: serviceInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(serviceInterface::class.java)
    }

    class ApiKeyInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            val url = request.url.newBuilder().addQueryParameter("key", API_KEY).build()
            request = request.newBuilder().url(url).build()
            return chain.proceed(request)
        }
    }
}



