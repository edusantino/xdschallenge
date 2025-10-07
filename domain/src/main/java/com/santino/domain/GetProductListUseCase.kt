package com.santino.domain

import kotlinx.coroutines.flow.Flow

interface GetProductListUseCase {
    fun getProductList(): Flow<List<ProductDetails>?>
}