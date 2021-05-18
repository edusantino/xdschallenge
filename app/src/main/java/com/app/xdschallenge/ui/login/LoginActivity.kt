package com.app.xdschallenge.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.xdschallenge.databinding.ActivityLoginBinding
import com.app.xdschallenge.ui.choiceflavor.ChoiceActivity

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

    override fun displayError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

//    override fun displayLoading(isLoading: Boolean) {
//        TODO("Not yet implemented")
//    }

    override fun navigateToEscolhaScreen() {
        val intent = Intent(this, ChoiceActivity::class.java)
        startActivity(intent)
    }
}
