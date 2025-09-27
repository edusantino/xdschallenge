package com.app.xdschallenge.data.datasource

import com.app.xdschallenge.data.repository.ProductRepositoryImpl
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

    val repository: ProductRepositoryImpl by lazy {
        ProductRepositoryImpl(
            apiDataSource = ApiDataSourceImpl(api),
            mockDataSource = MockDataSourceImpl()
        )
    }
}