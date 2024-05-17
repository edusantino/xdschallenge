package com.app.xdschallenge.ui.productlist

import com.app.xdschallenge.domain.remote.repository.ApiRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductListPresenter(private val view : ProductListContract.View?) : ProductListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun fetchList() {
        view?.showLoading(true)
        compositeDisposable.add(
            ApiRepository.getProductList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showLoading(false)
                    view?.setupProductList(it)
                }) { onError ->
                    run {
                        view?.displayError(onError.message.toString())
                        view?.showLoading(false)
                    }
                })
    }

    override fun start() {
    }
}
