package com.app.xdschallenge.domain.remote.services

import com.app.xdschallenge.domain.models.ProductModel
import com.app.xdschallenge.domain.models.Signin
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PizzaService {
    @GET("v1/pizza")
    fun getProductList(): Single<List<ProductModel?>>

    @GET("v1/pizza/{id}")
    fun getProductById(
        @Path(value = "id") id: String,
    ): Single<ProductModel?>

    @POST("v1/signin")
    fun doLogin(@Body login: Signin): Single<Signin?>
}