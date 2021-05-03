package com.app.xdschallenge.ui.login

import android.widget.Toast
import com.app.xdschallenge.data.models.Signin
import com.app.xdschallenge.data.remote.repository.PizzaRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    init {
        setupView()
    }

    fun setupView() {
        view.setupListeners()
    }

    override fun loadingUser() {
        val username = view.binding.edtUsuario.text.toString()
        val password = view.binding.edtSenha.text.toString()

        if (!validateLogin(username, password)) {
            return
        }

        val login = Signin(username,password)
        compositeDisposable.add(
            PizzaRepository.doLogin(login).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.navigateToEscolhaScreen()
                }) { onError ->
                    run {
                        //view.displayLoading(false)
                        view.displayError(onError.message.toString())
                    }
                })
    }

    override fun start() {
        TODO("Not yet implemented")
    }

    fun validateLogin(username: String, password: String) : Boolean {
        if(username.isEmpty() || password.isEmpty()){
            view.displayError("Usuário ou senha inválidos!")
            return false
        }
        return true
    }
}