package com.app.xdschallenge.domain.repository

import com.app.xdschallenge.domain.models.ProductDetails
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductList(): Flow<List<ProductDetails>?>
    fun getProductDetails(id: String): Flow<ProductDetails?>
}