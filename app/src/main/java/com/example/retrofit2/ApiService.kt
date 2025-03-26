package com.example.retrofit2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("planetary/apod")
    suspend fun getApod(@Query("fGP4BDSuz5JY7MOcyxYIke9s0Nf5Ik5BaptfA1bT") apiKey: String): Response<ApodResponse>
}
