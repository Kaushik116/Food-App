package com.kaushik.foodapp1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RestaurantAdapter(private val restaurantFamous: ArrayList<RestaurantDomain>) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.viewholder_restaurant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurantDomain = restaurantFamous[position]
        holder.title.text = restaurantDomain.getTitle()

        val context: Context = holder.itemView.context

        val drawableResourceId = context.resources.getIdentifier(
            restaurantDomain.getPic(),
            "drawable",
            context.packageName
        )

        Glide.with(context)
            .load(drawableResourceId)
            .into(holder.pic)

        val backgroundResourceId = when (position) {
            0 -> R.drawable.cart_background
            else -> R.drawable.cart_background
        }

        holder.mainLayout1.background =
            ContextCompat.getDrawable(context, backgroundResourceId)
    }

    override fun getItemCount(): Int {
        return restaurantFamous.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val mainLayout1: View = itemView.findViewById(R.id.mainLayout1)
    }
}