package com.app.xdschallenge.ui.choiceflav

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
import com.app.xdschallenge.databinding.CardsaborBinding
import com.app.xdschallenge.ui.detail.DetailActivity
import com.app.xdschallenge.utils.Tools
import com.bumptech.glide.Glide
import java.text.DecimalFormat

class EscolhaAdapter : RecyclerView.Adapter<EscolhaAdapter.RecyclerViewHolder>() {

    var tools: Tools = Tools()

    var pizzas: List<Pizza> = listOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var mBinding: CardsaborBinding
        var name: TextView
        var imgSabor: ImageView
        var price: TextView
        var rate: RatingBar
        var itemFlavor: RelativeLayout

        var data = Intent()

        init {
            name = itemView.findViewById(R.id.textSabor)
            imgSabor = itemView.findViewById(R.id.img_sabor)
            price = itemView.findViewById(R.id.textPreco)
            rate = itemView.findViewById(R.id.ratingBar)
            itemFlavor = itemView.findViewById(R.id.relativeFlavor)

            itemFlavor.setOnClickListener {
                    var position: Int = adapterPosition

                    if (position != RecyclerView.NO_POSITION) {
                        var context = itemView.context

                        val it = Intent(context, DetailActivity::class.java)
                        it.putExtra("pizza_detail",pizzas[position])
                        context.startActivity(it)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.cardsabor, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        holder.price.text = tools.converterMoney(pizzas[position].priceM)
        holder.name.text = pizzas[position].name
        holder.rate.rating = pizzas[position].rating?.toFloat()!!

        Glide.with(holder.imgSabor.context)
            .load(pizzas[position].imageUrl)
            .into(holder.imgSabor)
    }

    override fun getItemCount(): Int {
        return pizzas.size
    }
}