package com.santino.domain.datasource

import com.santino.domain.models.ProductDetails

interface ProductRemoteDataSource {
    suspend fun getProductCatalog(): List<ProductDetails>?
    suspend fun getProductDetails(id: String): ProductDetails?
}