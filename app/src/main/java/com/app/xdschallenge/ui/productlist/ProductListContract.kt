package com.app.xdschallenge.ui.productlist

import com.app.xdschallenge.base.BasePresenter
import com.app.xdschallenge.base.BaseView
import com.app.xdschallenge.domain.models.ProductModel

interface ProductListContract {

    interface View : BaseView<ProductListPresenter> {
        fun setupProductList(productList: List<ProductModel?>)
        fun displayError(msg: String)
        fun displayLoading(isLoading: Boolean)
    }

    interface Presenter : BasePresenter {
        fun loadProductList()
    }
}