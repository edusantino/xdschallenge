package com.app.xdschallenge.ui.choiceflav

import com.app.xdschallenge.base.BasePresenter
import com.app.xdschallenge.base.BaseView
import com.app.xdschallenge.data.models.Pizza

interface EscolhaContract {

    interface View : BaseView<EscolhaPresenter> {
        fun setupRecyclerViewPizzas(pizzas: List<Pizza?>)
        fun displayError(msg: String)
        fun displayLoading(isLoading: Boolean)
    }

    interface Presenter : BasePresenter {
        fun loadingPizzas()
    }
}