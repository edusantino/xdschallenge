package com.app.xdschallenge.ui.productlist

import com.app.xdschallenge.data.remote.repository.PizzaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductListPresenter(private val view : ProductListContract.View) : ProductListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadProducts() {
        view.displayLoading(true)
        compositeDisposable.add(
            PizzaRepository.getPizzas().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.displayLoading(false)
                    view.setupProductList(it)
                }) { onError ->
                    run {
                        view.displayError(onError.message.toString())
                    }
                })
    }

    override fun start() {
    }
}
