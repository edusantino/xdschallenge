package com.app.xdschallenge.ui.detail

import android.content.Intent
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
import com.app.xdschallenge.ui.success.FinishOrderFragment
import com.bumptech.glide.Glide


class ProductDetailsFragment : Fragment(), ProductDetailsContract.View {

    private var _binding: ProductDetailsFragmentBinding? = null
    private val binding get() = _binding!!

    override lateinit var presenter : ProductDetailsPresenter
    lateinit var mPizzas: Pizza

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View {
        _binding = ProductDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    binding.textPreco.setCharacterLists(TickerUtils.provideNumberList())
    binding.textPreco.setAnimationInterpolator(LinearInterpolator())


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

    override fun setupHeaderPizzaDetail(pizzas: Pizza) {
        mPizzas = pizzas
        Glide.with(binding.imgSabor.context)
            .load(pizzas.imageUrl)
            .into(binding.imgSabor)
        binding.textPreco.text = tools.converterMoney(pizzas.priceM)
        binding.textSabor.text = pizzas.name.toString()
        binding.ratingBar.rating = pizzas.rating?.toFloat()!!
    }

    override fun displayError(msg: String) {
        Toast.makeText(this, "Error on load!", Toast.LENGTH_SHORT).show()
    }

    override fun displayLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progress.visibility = View.VISIBLE
        } else {
            binding.progress.visibility = View.GONE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data!!.getSerializableExtra("pizza_details")
    }

    override fun onClickBuy() {
        val intent = Intent(this, FinishOrderFragment::class.java)
        startActivity(intent)
    }

    override fun onPricePClick() {
        binding.btnP.setBackgroundResource(R.drawable.border_button_green)
        binding.textPreco.text = tools.converterMoney(mPizzas.priceP)
        binding.btnP.setTextColor((Color.parseColor("#FFFFFF")))

        binding.btnG.setBackgroundResource(R.drawable.border_button_white)
        binding.btnG.setTextColor(Color.parseColor("#6A6A6A"))

        binding.btnM.setBackgroundResource(R.drawable.border_button_white)
        binding.btnM.setTextColor(Color.parseColor("#6A6A6A"))
    }

    override fun onPriceMClick() {
        binding.btnM.setBackgroundResource(R.drawable.border_button_green)
        binding.textPreco.text = tools.converterMoney(mPizzas.priceM)
        binding.btnM.setTextColor((Color.parseColor("#FFFFFF")))

        binding.btnG.setBackgroundResource(R.drawable.border_button_white)
        binding.btnG.setTextColor(Color.parseColor("#6A6A6A"))

        binding.btnP.setBackgroundResource(R.drawable.border_button_white)
        binding.btnP.setTextColor(Color.parseColor("#6A6A6A"))
    }

    override fun onPriceGClick() {
        binding.btnG.setBackgroundResource(R.drawable.border_button_green)
        binding.textPreco.text = tools.converterMoney(mPizzas.priceG)
        binding.btnG.setTextColor((Color.parseColor("#FFFFFF")))


        binding.btnP.setBackgroundResource(R.drawable.border_button_white)
        binding.btnP.setTextColor(Color.parseColor("#6A6A6A"))

        binding.btnM.setBackgroundResource(R.drawable.border_button_white)
        binding.btnM.setTextColor(Color.parseColor("#6A6A6A"))

    }

}