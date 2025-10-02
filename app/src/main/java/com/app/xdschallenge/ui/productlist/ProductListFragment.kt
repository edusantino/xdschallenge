package com.app.xdschallenge.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.xdschallenge.R
import com.app.xdschallenge.domain.models.ProductDetails
import com.app.xdschallenge.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment(), ProductsAdapterListener {

     lateinit var presenter: ProductListPresenter
    private lateinit var binding: ProductListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductListFragmentBinding.inflate(inflater, container, false)

        presenter = ProductListPresenter()
        presenter.start()
        presenter.loadProductList()
        return binding.root
    }

    fun setupProductList(productList: List<ProductDetails?>) {
        binding.productListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ProductsAdapter(productList, this@ProductListFragment)
            isVisible = productList.isNotEmpty()
        }
    }

     fun displayError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

     fun displayLoading(isLoading: Boolean) {
        binding.loading.isVisible = isLoading
    }

    override fun onItemClick(id: String?) {
        val bundle = bundleOf("id" to id)
        findNavController().navigate(R.id.action_productListFragment_to_productDetails, bundle)
    }
}