package com.app.xdschallenge.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.app.xdschallenge.databinding.ActivityLoginBinding
import com.app.xdschallenge.ui.choiceflav.EscolhaActivity

class LoginActivity : AppCompatActivity(), LoginContract.View {

    override lateinit var presenter: LoginPresenter
    override lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        var view: View = binding.root
        setContentView(view)

        presenter = LoginPresenter(this)
    }
    override fun setupListeners() {
        binding.btnLogar.setOnClickListener {
            presenter.loadingUser()
        }
    }

    fun validateLogin(username: String, password: String) : Boolean {
        if(username == null || username.trim().length == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if(password == null || password.trim().length == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false
        }
        return true
    }

    override fun displayError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

//    override fun displayLoading(isLoading: Boolean) {
//        TODO("Not yet implemented")
//    }

    override fun navigateToEscolhaScreen() {
        val intent = Intent(this, EscolhaActivity::class.java)
        startActivity(intent)
    }

}