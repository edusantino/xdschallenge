package com.app.xdschallenge.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.app.xdschallenge.R
import com.app.xdschallenge.data.models.Pizza
import com.app.xdschallenge.databinding.ProductDetailsFragmentBinding
import com.bumptech.glide.Glide
import com.robinhood.ticker.TickerUtils


class ProductDetailsFragment : Fragment(), ProductDetailsContract.View {

    private var _binding: ProductDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    override lateinit var presenter : ProductDetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View {
        _binding = ProductDetailsFragmentBinding.inflate(inflater, container, false)
        presenter = ProductDetailsPresenter(this)
        presenter.start()
        presenter.loadProducts()
        return binding.root
    }

    override fun setupProdutDetails(pizzas: List<Pizza?>) {
        val objPizza = pizzas.first { it?.id == arguments?.get("id") }

        Glide.with(binding.posterPath.context)
            .load(objPizza?.imageUrl)
            .into(binding.posterPath)

        binding.apply {
            flavorTitle.text = objPizza?.name.toString()
            ratingBar.rating = objPizza?.rating?.toFloat()!!
            priceTextView.setCharacterLists(TickerUtils.provideNumberList())
            priceTextView.text = objPizza.priceP.toString()


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
                priceTextView.text = objPizza.priceP.toString()
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
                priceTextView.text = objPizza.priceM.toString()
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
                priceTextView.text = objPizza.priceG.toString()
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
        findNavController().navigate(R.id.splashScreenFragment)
    }
}