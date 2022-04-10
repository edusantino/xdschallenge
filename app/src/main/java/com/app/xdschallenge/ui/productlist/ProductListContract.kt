package com.app.xdschallenge.ui.productlist

import com.app.xdschallenge.base.BasePresenter
import com.app.xdschallenge.base.BaseView
import com.app.xdschallenge.data.models.Pizza

interface ProductListContract {

    interface View : BaseView<ProductListPresenter> {
        fun setupProductList(pizzas: List<Pizza?>)
        fun displayError(msg: String)
        fun displayLoading(isLoading: Boolean)
    }

    interface Presenter : BasePresenter {
        fun loadProducts()
    }
}