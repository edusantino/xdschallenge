package com.santino.domain.repository

import com.santino.domain.models.ProductDetails
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductList(): Flow<List<ProductDetails>?>
    fun getProductDetails(id: String): Flow<ProductDetails?>
}