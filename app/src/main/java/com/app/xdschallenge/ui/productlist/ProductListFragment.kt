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
import com.app.xdschallenge.domain.models.ProductModel
import com.app.xdschallenge.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment(), ProductListContract.View, ProductsAdapterListener {

    override lateinit var presenter: ProductListPresenter
    private lateinit var binding: ProductListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductListFragmentBinding.inflate(inflater, container, false)

        presenter = ProductListPresenter(this)
        presenter.start()
        presenter.loadProductList()
        return binding.root
    }

    override fun setupProductList(productList: List<ProductModel?>) {
        binding.productListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ProductsAdapter(productList, this@ProductListFragment)
            isVisible = productList.isNotEmpty()
        }
    }

    override fun displayError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

    override fun displayLoading(isLoading: Boolean) {
        binding.loading.isVisible = isLoading
    }

    override fun onItemClick(id: String?) {
        val bundle = bundleOf("id" to id)
        findNavController().navigate(R.id.action_productListFragment_to_productDetails, bundle)
    }
}