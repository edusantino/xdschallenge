package com.app.xdschallenge.ui.choiceflavor

import com.app.xdschallenge.data.remote.repository.PizzaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ChoicePresenter(private val view: ChoiceContract.View) : ChoiceContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadingPizzas() {
        view.displayLoading(true)
        compositeDisposable.add(PizzaRepository.getPizzas().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.displayLoading(false)
                view.setupRecyclerViewPizzas(it)
            }) { onError ->
                run {
                    view.displayError(onError.message.toString())
                }
            })
    }

    override fun start() {
    }

}