package com.app.xdschallenge.ui.login

import com.app.xdschallenge.base.BaseView

interface LoginContract {

    interface View : BaseView<LoginContract> {
        //fun bindViews()
        fun navigateToProductList()
        fun displayError(msg: String)
        fun displayLoading(isLoading: Boolean)
        fun displaySuccess(isLoading: Boolean)
    }

    interface Presenter {
        fun isLoginValid(user: String, pass: String): Boolean
    }
}