package com.app.xdschallenge.data.remote.services

import com.app.xdschallenge.data.models.Pizza
import com.app.xdschallenge.data.models.Signin
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PizzaService {
    @GET("v1/pizza")
    fun searchPizza(): Single<List<Pizza?>>

    @POST("v1/signin")
    fun doLogin(@Body login: Signin): Single<Signin?>
}