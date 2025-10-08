package com.santino.data.datasource

import com.santino.domain.datasource.ProductRemoteDataSource
import com.santino.domain.models.ProductDetails
import kotlinx.coroutines.delay

class MockDataSourceImpl : ProductRemoteDataSource {
    override suspend fun getProductCatalog(): List<ProductDetails> {
        delay(500)
        return listOf(
            ProductDetails(
                id = "1",
                title = "Pepperoni Pizza",
                imageUrl = "",
                rating = 4.5f,
                priceList = listOf(22.21, 30.20, 50.30)
            ),
            ProductDetails(
                id = "2",
                title = "Margherita Pizza",
                imageUrl = "",
                rating = 4.2f,
                priceList = listOf(18.50, 25.00, 40.00)
            )
        )
    }

    override suspend fun getProductDetails(id: String): ProductDetails? {
        delay(300)
        return getProductCatalog().find { it.id == id }
    }
}