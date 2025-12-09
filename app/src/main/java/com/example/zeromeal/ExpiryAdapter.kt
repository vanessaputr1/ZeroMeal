package com.example.zeromeal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpiryAdapter(private val items: List<Ingredient>) :
    RecyclerView.Adapter<ExpiryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.iv_ingredient)
        val name: TextView = view.findViewById(R.id.tv_name)
        val expiry: TextView = view.findViewById(R.id.tv_expiry)
        val badge: TextView = view.findViewById(R.id.tv_badge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expiry, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.expiry.text = item.expiryDate
        holder.image.setImageResource(item.imageRes)

        when (item.daysUntilExpiry) {
            1 -> {
                holder.badge.text = "Urgent"
                holder.badge.setBackgroundResource(R.drawable.badge_urgent)
            }
            2, 3 -> {
                holder.badge.text = "Warning"
                holder.badge.setBackgroundResource(R.drawable.badge_warning)
            }
        }
    }

    override fun getItemCount() = items.size
}