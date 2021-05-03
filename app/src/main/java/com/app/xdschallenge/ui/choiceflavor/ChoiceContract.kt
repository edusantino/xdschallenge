package com.app.xdschallenge.ui.choiceflavor

import com.app.xdschallenge.base.BasePresenter
import com.app.xdschallenge.base.BaseView
import com.app.xdschallenge.data.models.Pizza

interface ChoiceContract {

    interface View : BaseView<ChoicePresenter> {
        fun setupRecyclerViewPizzas(pizzas: List<Pizza?>)
        fun displayError(msg: String)
        fun displayLoading(isLoading: Boolean)
    }

    interface Presenter : BasePresenter {
        fun loadingPizzas()
    }
}