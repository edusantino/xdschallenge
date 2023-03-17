package com.app.xdschallenge.domain.remote.repository

import com.app.xdschallenge.domain.models.Signin
import com.app.xdschallenge.domain.remote.datasource.PizzaRemoteDatasource

object ApiRepository {
    fun getProductList() = PizzaRemoteDatasource.getProductList()
}