package com.santino.core.network

import com.santino.data.model.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("v1/catalog")
    suspend fun getProductCatalog(): List<ProductDto>?

    @GET("v1/pizza/{id}")
    fun getProductById(
        @Path(value = "id") id: String,
    ): ProductDto?

    // @POST("v1/signin")
    // fun doLogin(@Body login: Signin): Single<Signin?>
}