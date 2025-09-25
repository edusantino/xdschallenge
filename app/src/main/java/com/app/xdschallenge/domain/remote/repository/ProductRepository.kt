package com.app.xdschallenge.domain.remote.repository

import com.app.xdschallenge.domain.models.ProductDetails
import com.app.xdschallenge.domain.remote.services.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepository(val apiService: ApiService) {
    fun getProductList(): Flow<List<ProductDetails>?> {
        return flow { emit(apiService.getProductList()) }
    }

    fun getProductDetails(id: String): Flow<ProductDetails?> {
        return flow {
            emit(apiService.getProductById(id))
        }
    }
}