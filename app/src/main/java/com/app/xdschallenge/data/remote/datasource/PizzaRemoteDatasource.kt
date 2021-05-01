package com.app.xdschallenge.data.remote.datasource

import com.app.xdschallenge.data.models.Signin
import com.app.xdschallenge.data.remote.RetrofitHelper
import com.app.xdschallenge.data.remote.services.PizzaService

object PizzaRemoteDatasource {

    // Pizzas List
    private val service = RetrofitHelper.createCall(PizzaService::class.java)
    fun getPizzas() = service.searchPizza()

    // User Login
    fun signIn(login: Signin) = service.doLogin(login)
}