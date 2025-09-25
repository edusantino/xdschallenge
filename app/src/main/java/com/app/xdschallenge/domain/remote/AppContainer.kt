package com.app.xdschallenge.domain.remote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.xdschallenge.domain.remote.repository.ProductRepository
import com.app.xdschallenge.domain.remote.services.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppContainer {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    val repository: ProductRepository by lazy {
        ProductRepository(api)
    }
}