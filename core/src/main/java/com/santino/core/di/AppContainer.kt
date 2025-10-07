package com.santino.core.di

import com.santino.core.network.ApiService
import com.santino.data.repository.ProductRepositoryImpl
import com.santino.domain.datasource.ApiDataSourceImpl
import com.santino.domain.datasource.MockDataSourceImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.getValue

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

    val repository: ProductRepositoryImpl by lazy {
        ProductRepositoryImpl(
            offlineDataSource = ApiDataSourceImpl(api),
            mockDataSource = MockDataSourceImpl()
        )
    }
}