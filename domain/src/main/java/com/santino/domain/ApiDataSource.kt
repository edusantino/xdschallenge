package com.santino.domain

interface ApiDataSource {
    suspend fun getProductList(): List<ProductDetails>?
    suspend fun getProductDetails(id: String): ProductDetails?
}