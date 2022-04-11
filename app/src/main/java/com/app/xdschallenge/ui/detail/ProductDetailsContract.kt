package com.app.xdschallenge.ui.detail

import com.app.xdschallenge.base.BasePresenter
import com.app.xdschallenge.base.BaseView
import com.app.xdschallenge.data.models.Pizza

interface ProductDetailsContract {

    interface View : BaseView<ProductDetailsPresenter> {
        fun setupProdutDetails(pizzas: List<Pizza?>)
        fun displayError(msg: String)
        fun displayLoading(isLoading: Boolean)
        fun onClickBuy()
        fun onPricePClick()
        fun onPriceMClick()
        fun onPriceGClick()
    }

    interface Presenter : BasePresenter {
        fun loadProducts()
    }
}