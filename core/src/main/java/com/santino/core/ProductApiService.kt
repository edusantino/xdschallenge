package com.santino.core

interface ProductApiService {
    @GET("v1/catalog")
    suspend fun getProductList(): List<ProductDto>?

    @GET("v1/pizza/{id}")
    fun getProductById(
        @Path(value = "id") id: String,
    ): ProductDto?

    @POST("v1/signin")
    fun doLogin(@Body login: Signin): Single<Signin?>
}