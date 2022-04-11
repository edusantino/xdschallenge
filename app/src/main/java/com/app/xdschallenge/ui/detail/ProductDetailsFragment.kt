package com.app.xdschallenge.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.xdschallenge.R
import com.app.xdschallenge.data.models.Pizza
import com.app.xdschallenge.databinding.ProductDetailsFragmentBinding
import com.bumptech.glide.Glide


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

    override fun onStart() {
        super.onStart()
        binding.btnComprar.setOnClickListener {
            onClickBuy()
        }

        binding.btnP.setOnClickListener {
            onPricePClick()
        }

        binding.btnM.setOnClickListener {
            onPriceMClick()
        }

        binding.btnG.setOnClickListener {
            onPriceGClick()
        }
    }

    override fun setupProdutDetails(pizzas: List<Pizza?>) {
        val objPizza = pizzas.first { it?.id == arguments?.get("id") }

        Glide.with(binding.imgSabor.context)
            .load(objPizza?.imageUrl)
            .into(binding.imgSabor)

        binding.apply {

        }
        binding.textSabor.text = objPizza?.name.toString()
        binding.ratingBar.rating = objPizza?.rating?.toFloat()!!
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

    override fun bindViews() {
        TODO("Not yet implemented")
    }

    override fun onClickBuy() {
        // TODO
    }

    override fun onPricePClick() {

        binding.btnP.setBackgroundResource(R.drawable.border_button_green)
        //binding.textPreco.text = tools.converterMoney(mPizzas.priceP)
        binding.btnP.setTextColor((Color.parseColor("#FFFFFF")))

        binding.btnG.setBackgroundResource(R.drawable.border_button_white)
        binding.btnG.setTextColor(Color.parseColor("#6A6A6A"))

        binding.btnM.setBackgroundResource(R.drawable.border_button_white)
        binding.btnM.setTextColor(Color.parseColor("#6A6A6A"))
    }

    override fun onPriceMClick() {
        binding.btnM.setBackgroundResource(R.drawable.border_button_green)
        //binding.textPreco.text = tools.converterMoney(mPizzas.priceM)
        binding.btnM.setTextColor((Color.parseColor("#FFFFFF")))

        binding.btnG.setBackgroundResource(R.drawable.border_button_white)
        binding.btnG.setTextColor(Color.parseColor("#6A6A6A"))

        binding.btnP.setBackgroundResource(R.drawable.border_button_white)
        binding.btnP.setTextColor(Color.parseColor("#6A6A6A"))
    }

    override fun onPriceGClick() {
        binding.btnG.setBackgroundResource(R.drawable.border_button_green)
        //binding.textPreco.text = tools.converterMoney(mPizzas.priceG)
        binding.btnG.setTextColor((Color.parseColor("#FFFFFF")))

        binding.btnP.setBackgroundResource(R.drawable.border_button_white)
        binding.btnP.setTextColor(Color.parseColor("#6A6A6A"))

        binding.btnM.setBackgroundResource(R.drawable.border_button_white)
        binding.btnM.setTextColor(Color.parseColor("#6A6A6A"))

    }

}