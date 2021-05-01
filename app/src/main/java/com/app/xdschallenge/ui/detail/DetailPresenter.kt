package com.app.xdschallenge.ui.detail

import com.app.xdschallenge.data.remote.repository.PizzaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailPresenter(private val view: DetailContract.View) : DetailContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadingPizzas() {
        view.displayLoading(true)
        compositeDisposable.add(PizzaRepository.getPizzas().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.displayLoading(false)
                }) { onError ->
                    run {
                        view.displayLoading(false)
                        view.displayError(onError.message.toString())
                    }
                })
    }

    override fun start() {
        TODO("Not yet implemented")
    }
}