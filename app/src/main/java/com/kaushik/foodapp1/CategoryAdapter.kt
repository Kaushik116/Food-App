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

class CategoryAdapter(private val categoryDomains: ArrayList<CategoryDomain>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.viewholder_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryDomain = categoryDomains[position]
        holder.categoryName.text = categoryDomain.title

        val picUrl = when (position) {
            0 -> "cat_1"
            1 -> "cat_2"
            2 -> "cat_3"
            3 -> "cat_4"
            4 -> "cat_5"
            else -> "cat_1"
        }

        val context: Context = holder.itemView.context

        val drawableResourceId =
            context.resources.getIdentifier(picUrl, "drawable", context.packageName)

        Glide.with(context)
            .load(drawableResourceId)
            .into(holder.categoryPic)

        val backgroundResourceId = when (position) {
            0 -> R.drawable.cat_background1
            1 -> R.drawable.cat_background2
            2 -> R.drawable.cat_background3
            3 -> R.drawable.cat_background4
            4 -> R.drawable.cat_background5
            else -> R.drawable.cat_background1
        }

        holder.mainLayout.background =
            ContextCompat.getDrawable(context, backgroundResourceId)
    }

    override fun getItemCount(): Int {
        return categoryDomains.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
        val categoryPic: ImageView = itemView.findViewById(R.id.categoryPic)
        val mainLayout: View = itemView.findViewById(R.id.mainLayout)
    }
}

