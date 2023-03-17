package com.app.xdschallenge.ui.detail

import com.app.xdschallenge.domain.remote.repository.ApiRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductDetailsPresenter(
    private val view: ProductDetailsContract.View
    ) : ProductDetailsContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadProductList() {
        view.displayLoading(true)
        compositeDisposable.add(
            ApiRepository.getProductList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ productList ->
                    view.displayLoading(false)
                    view.setupProdutDetails(productList)
                }) { onError ->
                    run {
                        view.displayLoading(false)
                        view.displayError(onError.message.toString())
                    }
                })
    }

    override fun start() {
    }
}