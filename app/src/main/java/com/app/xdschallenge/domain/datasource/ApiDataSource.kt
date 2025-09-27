package com.app.xdschallenge.domain.datasource

import com.app.xdschallenge.domain.models.ProductDetails

interface ApiDataSource {
    suspend fun getProductList(): List<ProductDetails>?
    suspend fun getProductDetails(id: String): ProductDetails?
}