package com.example.zeromeal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StokAdapter(private val items: List<Ingredient>) :
    RecyclerView.Adapter<StokAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.iv_ingredient)
        val name: TextView = view.findViewById(R.id.tv_name)
        val expiry: TextView = view.findViewById(R.id.tv_expiry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_stok, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.expiry.text = "Kedaluwarsa: ${item.expiryDate}"
        holder.image.setImageResource(item.imageRes)
    }

    override fun getItemCount() = items.size
}