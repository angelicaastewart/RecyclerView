package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.WishItemCellBinding

class WishItemAdapter(
    private val wishItems: List<WishItem>
) : RecyclerView.Adapter<WishItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = WishItemCellBinding.inflate(from, parent, false)
        return WishItemViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: WishItemViewHolder, position: Int) {
        holder.bindWishItem(wishItems[position])
    }

    override fun getItemCount(): Int = wishItems.size
}