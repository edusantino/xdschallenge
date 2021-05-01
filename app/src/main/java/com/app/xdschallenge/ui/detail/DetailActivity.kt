package com.app.xdschallenge.ui.detail

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.xdschallenge.R
import com.app.xdschallenge.data.models.Pizza
import com.app.xdschallenge.databinding.ActivityDetailBinding
import com.app.xdschallenge.ui.sucesso.SuccessActivity
import com.app.xdschallenge.utils.Tools
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity(), DetailContract.View {

    override lateinit var presenter : DetailPresenter
    lateinit var binding: ActivityDetailBinding
    lateinit var mPizzas: Pizza
    var tools: Tools = Tools()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupHeaderPizzaDetail(intent.getSerializableExtra("pizza_detail") as Pizza)
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

    override fun setupHeaderPizzaDetail(pizzas: Pizza) {
        mPizzas = pizzas
        Glide.with(binding.imgSabor.context)
            .load(pizzas.imageUrl)
            .into(binding.imgSabor)
        binding.textPreco.text = tools.converterMoney(pizzas.priceP)
        binding.textSabor.text = pizzas.name.toString()
        binding.ratingBar.rating = pizzas.rating?.toFloat()!!
    }

    override fun displayError(msg: String) {
        Toast.makeText(this, "Error on load!", Toast.LENGTH_SHORT).show()
    }

    override fun displayLoading(isLoading: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data!!.getSerializableExtra("pizza_details")
    }

    override fun onClickBuy() {
        val intent = Intent(this, SuccessActivity::class.java)
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