package com.santino.domain

import com.santino.domain.models.ProductDetails

interface OfflineDataSource {
    suspend fun getProductList(): List<ProductDetails>?
    suspend fun getProductDetails(id: String): ProductDetails?
}