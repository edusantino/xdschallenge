package com.app.xdschallenge.ui.detail

import com.app.xdschallenge.base.BasePresenter
import com.app.xdschallenge.base.BaseView
import com.app.xdschallenge.domain.models.ProductDetails

interface ProductDetailsContract {

    interface View : BaseView<ProductDetailsPresenter> {
        fun setupProductDetails(productList: List<ProductDetails?>)
        fun displayError(msg: String)
        fun displayLoading(isLoading: Boolean)
        fun onClickBuy()

    }

    interface Presenter : BasePresenter {
        fun loadProductList()
    }
}