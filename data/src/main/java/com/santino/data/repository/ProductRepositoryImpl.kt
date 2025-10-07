package com.santino.data.repository

import com.santino.domain.OfflineDataSource
import com.santino.domain.models.ProductDetails
import com.santino.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl(
    val offlineDataSource: OfflineDataSource,
    val mockDataSource: OfflineDataSource
): ProductRepository {
    override fun getProductList(): Flow<List<ProductDetails>?> = flow {
        try {
            emit(offlineDataSource.getProductList())
        } catch (t: Throwable) {
            println("Error - ${t.message} - using offline data.")
            emit(mockDataSource.getProductList())
        }
    }

    override fun getProductDetails(id: String): Flow<ProductDetails?> {
        return flow {
            try {
                emit(offlineDataSource.getProductDetails(id))
            } catch (t: Throwable) {
                println("Error - ${t.message} - using offline data.")
                emit(mockDataSource.getProductDetails(id))
            }
        }
    }
}