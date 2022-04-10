/*
package com.app.xdschallenge.ui.login

import com.app.xdschallenge.data.models.Signin
import com.app.xdschallenge.data.remote.repository.PizzaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    init {
        setupView()
    }

    fun setupView() {
        view.setupListeners()
    }

    override fun isLoginValid(user: String, pass: String): Boolean {

        val compositeDisposable = CompositeDisposable()

        if (user.isEmpty() || pass.isEmpty()){
            view.displayError("Usuário ou senha inválidos!")
            return false
        } else {
            return true
        }

        compositeDisposable.add(
            PizzaRepository.doLogin(login).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.navigateToCartFragment()
                }) { onError ->
                    run {
                        view.displayError("Usuário ou senha inválidos!")
                    }
                })
    }
}*/
