package com.santino.domain

import com.santino.domain.models.ProductDetails
import kotlinx.coroutines.flow.Flow

interface GetProductListUseCase {
    fun getProductList(): Flow<List<ProductDetails>?>
}