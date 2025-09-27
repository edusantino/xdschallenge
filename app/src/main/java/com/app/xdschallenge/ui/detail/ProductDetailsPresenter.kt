package com.app.xdschallenge.ui.detail

import io.reactivex.disposables.CompositeDisposable

class ProductDetailsPresenter(
    private val view: ProductDetailsContract.View
    ) : ProductDetailsContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadProductList() {
        view.displayLoading(true)
    }

    override fun start() {
    }
}