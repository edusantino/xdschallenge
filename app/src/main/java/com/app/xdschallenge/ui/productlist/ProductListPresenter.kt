package com.app.xdschallenge.ui.productlist

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductListPresenter() {

    private val compositeDisposable = CompositeDisposable()

     fun loadProductList() {
//        view.displayLoading(true)
//        compositeDisposable.add(
//            Repository.getProductList().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    view.displayLoading(false)
//                    view.setupProductList(it)
//                }) { onError ->
//                    run {
//                        view.displayError(onError.message.toString())
//                        view.displayLoading(false)
//                    }
//                })
    }

     fun start() {
    }
}
