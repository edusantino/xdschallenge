package com.app.xdschallenge.ui.productlist

import androidx.recyclerview.widget.RecyclerView
import com.app.xdschallenge.domain.models.ProductDetails
import com.app.xdschallenge.databinding.FlavorItemBinding
import com.bumptech.glide.Glide

class ProductViewHolder(
    private val binding: FlavorItemBinding,
    private val listener: ProductsAdapterListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(product: ProductDetails?) {
        setupViews(product)
        setupListener(product?.id)
    }

    private fun setupViews(product: ProductDetails?) {
        binding.apply {
            rtProductRating.rating = product?.rating?.toFloat() ?: 0.0f
            //txPrice.text = Tools.printPrice(product?.priceM)
            txFlavorTitle.text = product?.name

            Glide.with(this.root.context)
                .load(product?.imageUrl)
                .into(ivPosterPath)
        }
    }

    private fun setupListener(productId: String?) {
        binding.cardFlavor.setOnClickListener {
            listener.onItemClick(productId)
        }
    }
}