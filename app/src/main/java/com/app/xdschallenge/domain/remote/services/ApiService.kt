package com.app.xdschallenge.domain.remote.services

import com.app.xdschallenge.domain.models.ProductDetails
import com.app.xdschallenge.domain.models.Signin
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("v1/catalog")
    suspend fun getProductList(): List<ProductDetails>?

    @GET("v1/pizza/{id}")
    fun getProductById(
        @Path(value = "id") id: String,
    ): ProductDetails?

    @POST("v1/signin")
    fun doLogin(@Body login: Signin): Single<Signin?>
}