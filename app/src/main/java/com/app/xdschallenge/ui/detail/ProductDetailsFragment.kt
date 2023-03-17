package com.app.xdschallenge.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.xdschallenge.R
import com.app.xdschallenge.domain.models.ProductModel
import com.app.xdschallenge.databinding.ProductDetailsFragmentBinding
import com.bumptech.glide.Glide
import com.robinhood.ticker.TickerUtils

class ProductDetailsFragment : Fragment(), ProductDetailsContract.View {

    override lateinit var presenter : ProductDetailsPresenter
    lateinit var binding: ProductDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View {
        binding = ProductDetailsFragmentBinding.inflate(inflater, container, false)

        presenter = ProductDetailsPresenter(this)
        presenter.start()
        presenter.loadProductList()
        return binding.root
    }

    override fun setupProdutDetails(productList: List<ProductModel?>) {
        val product = productList.first { it?.id == arguments?.get("id") }

        Glide.with(binding.ivPosterPath.context)
            .load(product?.imageUrl)
            .into(binding.ivPosterPath)

        binding.apply {
            flavorTitle.text = product?.name.toString()
            rtProductRating.rating = product?.rating?.toFloat() ?: 0.0f
            txPrice.setCharacterLists(TickerUtils.provideNumberList())
            txPrice.text = "R$ ${product?.priceP.toString()},00"

            sizeP.setOnClickListener {
                sizeP.apply {
                    background = ContextCompat.getDrawable(requireContext(), R.drawable.border_button_green)
                    setTextColor(Color.parseColor("#FFFFFF"))
                }

                sizeM.apply {
                    background = ContextCompat.getDrawable(requireContext(), R.drawable.border_button_white)
                    setTextColor(Color.parseColor("#6A6A6A"))
                }

                sizeX.apply {
                    setBackgroundResource(R.drawable.border_button_white)
                    setTextColor(Color.parseColor("#6A6A6A"))
                }
                txPrice.text = "R$ ${product?.priceP.toString()},00"
            }

            sizeM.setOnClickListener {
                sizeM.apply {
                    setBackgroundResource(R.drawable.border_button_green)
                    setTextColor(Color.parseColor("#FFFFFF"))
                }

                sizeP.apply {
                    setBackgroundResource(R.drawable.border_button_white)
                    setTextColor(Color.parseColor("#6A6A6A"))
                }

                sizeX.apply {
                    setBackgroundResource(R.drawable.border_button_white)
                    setTextColor(Color.parseColor("#6A6A6A"))
                }
                txPrice.text = "R$ ${product?.priceM.toString()},00"
            }

            sizeX.setOnClickListener {
                sizeX.apply {
                    setBackgroundResource(R.drawable.border_button_green)
                    setTextColor(Color.parseColor("#FFFFFF"))
                }

                sizeP.apply {
                    setBackgroundResource(R.drawable.border_button_white)
                    setTextColor(Color.parseColor("#6A6A6A"))
                }

                sizeM.apply {
                    setBackgroundResource(R.drawable.border_button_white)
                    setTextColor(Color.parseColor("#6A6A6A"))
                }
                txPrice.text = "R$ ${product?.priceG.toString()},00"
            }

            btnBuy.setOnClickListener {
                onClickBuy()
            }
        }
    }

    override fun displayError(msg: String) {
        Toast.makeText(context, "Error on load!", Toast.LENGTH_SHORT).show()
    }

    override fun displayLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progress.visibility = View.VISIBLE
        } else {
            binding.progress.visibility = View.GONE
        }
    }

    override fun onClickBuy() {
        findNavController().navigate(R.id.action_productDetailsFragment_to_finishOrderFragment)
    }
}