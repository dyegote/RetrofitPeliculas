package com.example.mispeliculas.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceBuilder(baseUrl: String) {

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildServices(service: Class<T>): T {
        return  retrofit.create(service)
    }
}