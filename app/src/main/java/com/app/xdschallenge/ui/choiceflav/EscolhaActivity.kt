package com.app.xdschallenge.ui.choiceflav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.xdschallenge.R
import com.app.xdschallenge.data.models.Pizza
import com.app.xdschallenge.databinding.ActivityChoiceFlavorBinding

class EscolhaActivity : AppCompatActivity(), EscolhaContract.View {

    override lateinit var presenter: EscolhaPresenter
    lateinit var binding: ActivityChoiceFlavorBinding

    private val adapter by lazy {
        val adapter = EscolhaAdapter()
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoiceFlavorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter = EscolhaPresenter(this)
        presenter.loadingPizzas()
    }

     override fun setupRecyclerViewPizzas(pizzas: List<Pizza?>) {
        binding.rcvPizzas.layoutManager = LinearLayoutManager(this)
        adapter.pizzas = pizzas as List<Pizza>
        binding.rcvPizzas.adapter = adapter
    }

    override fun displayError(msg: String) {
        Toast.makeText(this, msg,
            Toast.LENGTH_LONG).show()
    }

    override fun displayLoading(isLoading: Boolean) {
        Toast.makeText(this, "OK",
            Toast.LENGTH_SHORT).show()
    }
}