package com.santino.data.repository

import com.app.xdschallenge.domain.datasource.ApiDataSource
import com.app.xdschallenge.domain.models.ProductDetails
import com.app.xdschallenge.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl(
    val apiDataSource: ApiDataSource,
    val mockDataSource: ApiDataSource
): ProductRepository {
    override fun getProductList(): Flow<List<ProductDetails>?> = flow {
        try {
            emit(apiDataSource.getProductList())
        } catch (t: Throwable) {
            println("Error - ${t.message} - using offline data.")
            emit(mockDataSource.getProductList())
        }
    }

    override fun getProductDetails(id: String): Flow<ProductDetails?> {
        return flow {
            try {
                emit(apiDataSource.getProductDetails(id))
            } catch (t: Throwable) {
                println("Error - ${t.message} - using offline data.")
                emit(mockDataSource.getProductDetails(id))
            }
        }
    }
}