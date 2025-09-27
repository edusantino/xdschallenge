package com.app.xdschallenge.domain.usecase

import com.app.xdschallenge.domain.models.ProductDetails
import kotlinx.coroutines.flow.Flow

interface GetProductListUseCase {
    fun getProductList(): Flow<List<ProductDetails>?>
}