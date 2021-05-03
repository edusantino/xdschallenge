package com.app.xdschallenge.ui.choiceflavor

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
import com.app.xdschallenge.databinding.FlavorcardBinding
import com.app.xdschallenge.ui.detail.DetailActivity
import com.app.xdschallenge.utils.Tools
import com.bumptech.glide.Glide

class ChoiceAdapter : RecyclerView.Adapter<ChoiceAdapter.RecyclerViewHolder>() {

    var tools: Tools = Tools()

    var mPizzaListBkp: List<Pizza> = listOf()
    var mPizzaList: List<Pizza> = listOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var imgSabor: ImageView
        var price: TextView
        var rate: RatingBar
        var itemFlavor: RelativeLayout
        var data = Intent()

        init {
            itemFlavor = itemView.findViewById(R.id.relativeFlavor)
            name = itemView.findViewById(R.id.textSabor)
            imgSabor = itemView.findViewById(R.id.img_sabor)
            price = itemView.findViewById(R.id.textPreco)
            rate = itemView.findViewById(R.id.ratingBar)

           itemFlavor.setOnClickListener {
                    var position: Int = adapterPosition

                    if (position != RecyclerView.NO_POSITION) {
                        var context = itemView.context

                        val it = Intent(context, DetailActivity::class.java)
                        it.putExtra("pizza_detail",mPizzaList[position])
                        context.startActivity(it)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.flavorcard, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        holder.price.text = tools.converterMoney(mPizzaList[position].priceM)
        holder.name.text = mPizzaList[position].name
        holder.rate.rating = mPizzaList[position].rating?.toFloat()!!

        Glide.with(holder.imgSabor.context)
            .load(mPizzaList[position].imageUrl)
            .into(holder.imgSabor)
    }

    override fun getItemCount(): Int {
        return mPizzaList.size
    }

    fun filterList(filteredList: ArrayList<Pizza>) {
        mPizzaList = filteredList
        notifyDataSetChanged()
    }
}