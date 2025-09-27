package com.app.xdschallenge.data.datasource

import com.app.xdschallenge.data.model.toDomain
import com.app.xdschallenge.domain.datasource.ApiDataSource
import com.app.xdschallenge.domain.models.ProductDetails

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