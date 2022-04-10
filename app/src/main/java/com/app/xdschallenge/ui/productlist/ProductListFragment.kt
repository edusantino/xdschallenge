package com.app.xdschallenge.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.xdschallenge.data.models.Pizza
import com.app.xdschallenge.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment(), ProductListContract.View {

    override lateinit var presenter: ProductListPresenter
    private var _binding: ProductListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProductListFragmentBinding.inflate(inflater, container, false)

        presenter = ProductListPresenter(this)
        presenter.start()
        presenter.loadProducts()
        return binding.root
    }

    override fun bindViews() {
    }

    override fun setupProductList(pizzas: List<Pizza?>) {
        val adapter = ProductsAdapter()
        adapter.mProductsList = pizzas
        binding.productListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
            visibility = View.VISIBLE
        }
    }

    override fun displayError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

    override fun displayLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.apply {
                progressView.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                progressView.visibility = View.GONE
            }
        }
    }
}