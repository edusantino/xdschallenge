package com.app.xdschallenge.ui.productlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.app.xdschallenge.R
import com.app.xdschallenge.data.models.Pizza
import com.bumptech.glide.Glide
import java.text.DecimalFormat

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.RecyclerViewHolder>() {
    var mProductsList: List<Pizza?> = listOf()

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var imgFlavor: ImageView
        var price: TextView
        var rate: RatingBar
        var itemFlavor: RelativeLayout
        var data = Intent()

        init {
            itemFlavor = itemView.findViewById(R.id.relativeFlavor)
            title = itemView.findViewById(R.id.textSabor)
            imgFlavor = itemView.findViewById(R.id.img_sabor)
            price = itemView.findViewById(R.id.textPreco)
            rate = itemView.findViewById(R.id.ratingBar)

           itemFlavor.setOnClickListener {
                    val position: Int = adapterPosition

                    if (position != RecyclerView.NO_POSITION) {
                        Navigation.findNavController(itemView).navigate(R.id.action)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.flavorcard_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.price.text = mProductsList[position]?.priceM.convertMoney()
        holder.title.text = mProductsList[position]?.name
        holder.rate.rating = mProductsList[position]?.rating?.toFloat()!!

        Glide.with(holder.imgFlavor.context)
            .load(mProductsList[position]?.imageUrl)
            .into(holder.imgFlavor)
    }

    override fun getItemCount(): Int {
        return mProductsList.size
    }

    private fun Number?.convertMoney(): String = "R$ ${DecimalFormat("##.00").format(this).replace(".", ",")}"
}