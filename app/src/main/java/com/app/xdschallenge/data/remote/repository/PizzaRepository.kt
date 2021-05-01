package com.app.xdschallenge.data.remote.repository

import com.app.xdschallenge.data.models.Signin
import com.app.xdschallenge.data.remote.datasource.PizzaRemoteDatasource

object PizzaRepository {

    //get Pizzas List
    fun getPizzas() = PizzaRemoteDatasource.getPizzas()

    //get User
    fun doLogin(login: Signin) = PizzaRemoteDatasource.signIn(login)
}