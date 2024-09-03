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

class PopularAdapter(private val popularFood: ArrayList<FoodDomain>) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.viewholder_popular, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodDomain = popularFood[position]
        holder.title.text = foodDomain.getTitle()
        holder.fee.text = foodDomain.getFee().toString()

        val context: Context = holder.itemView.context

        val drawableResourceId = context.resources.getIdentifier(
            foodDomain.getPic(),
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

        holder.mainLayout.background =
            ContextCompat.getDrawable(context, backgroundResourceId)
    }

    override fun getItemCount(): Int {
        return popularFood.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val fee: TextView = itemView.findViewById(R.id.fee)
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val addBtn: TextView = itemView.findViewById(R.id.addBtn)
        val mainLayout: View = itemView.findViewById(R.id.mainLayout)
    }
}
