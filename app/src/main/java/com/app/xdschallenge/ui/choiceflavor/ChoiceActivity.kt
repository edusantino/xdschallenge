package com.app.xdschallenge.ui.choiceflavor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.xdschallenge.data.models.Pizza
import com.app.xdschallenge.databinding.ActivityChoiceFlavorBinding

class ChoiceActivity : AppCompatActivity(), ChoiceContract.View {

    override lateinit var presenter: ChoicePresenter
    lateinit var binding: ActivityChoiceFlavorBinding

    private val adapter by lazy {
        val adapter = ChoiceAdapter()
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoiceFlavorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter = ChoicePresenter(this)
        presenter.loadingPizzas()

        // Search bar
        binding.edtSearch.addTextChangedListener( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }
        })
    }

    // Search bar func
    fun filter(text: String) {
        var filteredList: ArrayList<Pizza> = ArrayList()

        for (item in adapter.mPizzaList) {
            if (item.name?.toLowerCase()?.contains(text.toLowerCase()) == true) {
                filteredList.add(item)
            }
        }

        if (binding.edtSearch.text.trim().isEmpty()) {
            filteredList.clear()
            adapter.mPizzaList = adapter.mPizzaListBkp
            filteredList.addAll(adapter.mPizzaListBkp)
        }
        adapter.filterList(filteredList)
    }

     override fun setupRecyclerViewPizzas(pizzas: List<Pizza?>) {
        binding.rcvPizzas.layoutManager = LinearLayoutManager(this)
        binding.rcvPizzas.adapter = adapter
         adapter.mPizzaList = pizzas as List<Pizza>
         adapter.mPizzaListBkp = pizzas
    }

    override fun displayError(msg: String) {
        Toast.makeText(this, msg,
            Toast.LENGTH_LONG).show()
    }

    override fun displayLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progress.visibility = View.VISIBLE
        } else {
            binding.progress.visibility = View.GONE
        }
    }
}