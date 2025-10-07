package com.santino.domain.datasource

import com.google.firebase.appdistribution.gradle.ApiService
import com.santino.domain.models.ProductDetails

class ApiDataSourceImpl(val apiService: ApiService): ApiDataSource {
    override suspend fun getProductList(): List<ProductDetails>? {
        return apiService.getProductList()?.map {
            it.toDomain()
        }
    }

    override suspend fun getProductDetails(id: String): ProductDetails? {
        TODO("Not yet implemented")
    }
}