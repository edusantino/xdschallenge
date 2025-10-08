package com.santino.data.datasource

import com.santino.domain.datasource.ProductRemoteDataSource
import com.santino.domain.models.ProductDetails

class ProductRemoteDataSourceImpl(): ProductRemoteDataSource {
    override suspend fun getProductCatalog(): List<ProductDetails>? {
        TODO("Not yet implemented")
    }

    override suspend fun getProductDetails(id: String): ProductDetails? {
        TODO("Not yet implemented")
    }
}