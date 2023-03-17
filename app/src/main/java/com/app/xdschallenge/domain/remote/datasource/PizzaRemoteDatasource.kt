package com.app.xdschallenge.domain.remote.datasource

import com.app.xdschallenge.domain.models.Signin
import com.app.xdschallenge.domain.remote.RetrofitHelper
import com.app.xdschallenge.domain.remote.services.PizzaService

object PizzaRemoteDatasource {

    private val service = RetrofitHelper.createCall(PizzaService::class.java)
    fun getProductList() = service.getProductList()
    fun signIn(login: Signin) = service.doLogin(login)
    fun getProductById(id: String) = service.getProductById(id)
}