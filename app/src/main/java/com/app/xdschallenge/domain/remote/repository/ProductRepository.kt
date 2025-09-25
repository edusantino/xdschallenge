package com.app.xdschallenge.domain.remote.repository

import com.app.xdschallenge.domain.models.ProductDetails
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductList(): Flow<List<ProductDetails>?>
    fun getProductDetails(id: String): Flow<ProductDetails?>
}