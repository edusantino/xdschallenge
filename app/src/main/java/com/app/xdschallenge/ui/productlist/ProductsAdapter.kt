package com.app.xdschallenge.ui.productlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.xdschallenge.R
import com.app.xdschallenge.data.models.Pizza
import com.bumptech.glide.Glide
import java.text.DecimalFormat

class ProductsAdapter(
    private val dataset: List<Pizza?>,
    private val listener: OnItemClick
) : RecyclerView.Adapter<ProductsAdapter.RecyclerViewHolder>() {

    interface OnItemClick {
        fun onItemClick(id: String)
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var title: TextView
        var imgFlavor: ImageView
        var price: TextView
        var rate: RatingBar
        var itemFlavor: RelativeLayout
        var data = Intent()

        init {
            itemFlavor = itemView.findViewById(R.id.relativeFlavor)
            title = itemView.findViewById(R.id.flavorTextView)
            imgFlavor = itemView.findViewById(R.id.posterPath)
            price = itemView.findViewById(R.id.priceTextView)
            rate = itemView.findViewById(R.id.ratingBar)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                dataset[position]?.id?.let { listener.onItemClick(it) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.flavorcard_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.price.text = dataset[position]?.priceM.convertMoney()
        holder.title.text = dataset[position]?.name
        holder.rate.rating = dataset[position]?.rating?.toFloat()!!

        Glide.with(holder.imgFlavor.context)
            .load(dataset[position]?.imageUrl)
            .into(holder.imgFlavor)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    private fun Number?.convertMoney(): String = "R$ ${DecimalFormat("##.00").format(this).replace(".", ",")}"
}