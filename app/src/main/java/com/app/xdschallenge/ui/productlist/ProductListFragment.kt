package com.app.xdschallenge.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.xdschallenge.R
import com.app.xdschallenge.data.models.Pizza
import com.app.xdschallenge.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment(), ProductListContract.View, ProductsAdapter.OnItemClick {

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
        val adapter = ProductsAdapter(pizzas, this)
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

    override fun onItemClick(id: String) {
        val bundle = bundleOf("id" to id)
        findNavController().navigate(R.id.action_productListFragment_to_productDetails, bundle)
    }
}