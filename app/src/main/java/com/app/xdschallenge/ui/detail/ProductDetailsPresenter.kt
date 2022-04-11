package com.app.xdschallenge.ui.detail

import com.app.xdschallenge.data.remote.repository.PizzaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductDetailsPresenter(private val view: ProductDetailsContract.View) : ProductDetailsContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadProducts() {
        view.displayLoading(true)
        compositeDisposable.add(PizzaRepository.getPizzas().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.displayLoading(false)
                    view.setupProdutDetails(it)

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