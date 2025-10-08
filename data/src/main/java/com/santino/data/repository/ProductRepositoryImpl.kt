package com.santino.data.repository

import com.santino.domain.datasource.ProductRemoteDataSource
import com.santino.domain.models.ProductDetails
import com.santino.domain.repository.ConfigRepository
import com.santino.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class ProductRepositoryImpl(
    val remoteConfig: ConfigRepository,
    val offlineDataSource: ProductRemoteDataSource,
    val mockDataSource: ProductRemoteDataSource
): ProductRepository {

    /* 1. Remote Config
    *  2. Local Json
    *  3. Mocked Data
    * */
    override fun getProductList(): Flow<List<ProductDetails>?> =
        flow {
            val jsonString = remoteConfig.getString("pizza_catalog")
            val products = Json.decodeFromString<List<ProductDetails>>(jsonString)
            println("Remote config result: [$jsonString]")
            emit(products)
        }.catch { t ->
            try {
                println("Error on fetch Firebase - ${t.message} - using api data.")
                emit(offlineDataSource.getProductCatalog() ?: emptyList())
            } catch (t2: Throwable) {
                println("Error - ${t2.message} - using offline data.")
                emit(mockDataSource.getProductCatalog() ?: emptyList())
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