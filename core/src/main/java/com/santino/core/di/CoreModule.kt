package com.santino.core.di

import com.santino.core.network.ProductApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CoreModule {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }
}