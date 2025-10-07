package com.santino.domain.datasource

import com.app.xdschallenge.domain.datasource.ApiDataSource
import com.app.xdschallenge.domain.models.ProductDetails
import kotlinx.coroutines.delay

class MockDataSourceImpl : ApiDataSource {
    override suspend fun getProductList(): List<ProductDetails> {
        delay(500)
        return listOf(
            ProductDetails(
                id = "1",
                name = "Pepperoni Pizza",
                imageUrl = "",
                rating = 4.5f,
                priceList = listOf(22.21, 30.20, 50.30)
            ),
            ProductDetails(
                id = "2",
                name = "Margherita Pizza",
                imageUrl = "",
                rating = 4.2f,
                priceList = listOf(18.50, 25.00, 40.00)
            )
        )
    }

    override suspend fun getProductDetails(id: String): ProductDetails? {
        delay(300)
        return getProductList().find { it.id == id }
    }
}