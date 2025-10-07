package com.santino.domain

import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductList(): Flow<List<ProductDetails>?>
    fun getProductDetails(id: String): Flow<ProductDetails?>
}