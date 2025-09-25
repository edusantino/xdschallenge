package com.app.xdschallenge.ui.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.xdschallenge.domain.models.ProductDetails
import com.app.xdschallenge.databinding.FlavorItemBinding
import java.text.DecimalFormat

class ProductsAdapter(
    private val dataset: List<ProductDetails?>,
    private val listener: ProductsAdapterListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(FlavorItemBinding.inflate(inflater, parent, false), listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductViewHolder) {
            holder.bind(dataset[position])
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    private fun Number?.convertMoney(): String = "R$ ${DecimalFormat("##.00").format(this).replace(".", ",")}"
}