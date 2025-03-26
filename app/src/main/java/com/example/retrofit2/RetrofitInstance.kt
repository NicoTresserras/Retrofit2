package com.example.retrofit2

import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object RetrofitInstance {
    private const val BASE_URL = "https://api.nasa.gov/"

    private val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer YOUR_API_KEY") // Reemplaza con tu API Key
                .build()
            chain.proceed(request)
        }
    }.build()

    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}
