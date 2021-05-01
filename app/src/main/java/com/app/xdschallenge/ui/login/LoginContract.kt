package com.app.xdschallenge.ui.login

import com.app.xdschallenge.base.BasePresenter
import com.app.xdschallenge.base.BaseView
import com.app.xdschallenge.databinding.ActivityLoginBinding


interface LoginContract {

    interface View : BaseView<LoginPresenter> {
        var binding: ActivityLoginBinding
        fun displayError(msg: String)
        //fun displayLoading(isLoading: Boolean)
        fun navigateToEscolhaScreen()
        fun setupListeners()
    }

    interface Presenter : BasePresenter {
        fun loadingUser()
    }
}