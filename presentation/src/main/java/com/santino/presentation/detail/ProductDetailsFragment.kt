package com.santino.presentation.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.app.xdschallenge.R
import com.app.xdschallenge.domain.models.ProductDetails
import com.app.xdschallenge.databinding.ProductDetailsFragmentBinding
import com.bumptech.glide.Glide
import com.robinhood.ticker.TickerUtils

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: ProductDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View {
        binding = ProductDetailsFragmentBinding.inflate(inflater, container, false)


        return binding.root
    }

    fun setupProductDetails(productList: List<ProductDetails?>) {
        val product = productList.first { it?.id == arguments?.get("id") }

        Glide.with(binding.ivPosterPath.context)
            .load(product?.imageUrl)
            .into(binding.ivPosterPath)

        binding.apply {
            flavorTitle.text = product?.name.toString()
            rtProductRating.rating = product?.rating?.toFloat() ?: 0.0f
            txPrice.setCharacterLists(TickerUtils.provideNumberList())
            //txPrice.text = product?.priceP?.toPrice()

            sizeP.setOnClickListener {
                sizeP.apply {
                    View.setBackground = ContextCompat.getDrawable(requireContext(), R.drawable.border_button_green)
                    TextView.setTextColor(Color.parseColor("#FFFFFF"))
                }

                sizeM.apply {
                    View.setBackground = ContextCompat.getDrawable(requireContext(), R.drawable.border_button_white)
                    TextView.setTextColor(Color.parseColor("#6A6A6A"))
                }

                sizeX.apply {
                    View.setBackgroundResource(R.drawable.border_button_white)
                    TextView.setTextColor(Color.parseColor("#6A6A6A"))
                }
                //txPrice.text = "R$ ${product?.priceP.toString()},00"
            }

            sizeM.setOnClickListener {
                sizeM.apply {
                    View.setBackgroundResource(R.drawable.border_button_green)
                    TextView.setTextColor(Color.parseColor("#FFFFFF"))
                }

                sizeP.apply {
                    View.setBackgroundResource(R.drawable.border_button_white)
                    TextView.setTextColor(Color.parseColor("#6A6A6A"))
                }

                sizeX.apply {
                    View.setBackgroundResource(R.drawable.border_button_white)
                    TextView.setTextColor(Color.parseColor("#6A6A6A"))
                }
                //txPrice.text = "R$ ${product?.priceM.toString()},00"
            }

            sizeX.setOnClickListener {
                sizeX.apply {
                    View.setBackgroundResource(R.drawable.border_button_green)
                    TextView.setTextColor(Color.parseColor("#FFFFFF"))
                }

                sizeP.apply {
                    View.setBackgroundResource(R.drawable.border_button_white)
                    TextView.setTextColor(Color.parseColor("#6A6A6A"))
                }

                sizeM.apply {
                    View.setBackgroundResource(R.drawable.border_button_white)
                    TextView.setTextColor(Color.parseColor("#6A6A6A"))
                }
                //txPrice.text = "R$ ${product?.priceG.toString()},00"
            }

            btnBuy.setOnClickListener {
            }
        }
    }
}