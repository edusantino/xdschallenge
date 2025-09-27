package com.app.xdschallenge.data.datasource

import com.app.xdschallenge.data.model.ProductDto
import com.app.xdschallenge.domain.models.Signin
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("v1/catalog")
    suspend fun getProductList(): List<ProductDto>?

    @GET("v1/pizza/{id}")
    fun getProductById(
        @Path(value = "id") id: String,
    ): ProductDto?

    @POST("v1/signin")
    fun doLogin(@Body login: Signin): Single<Signin?>
}