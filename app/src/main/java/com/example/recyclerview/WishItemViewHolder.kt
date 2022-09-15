package com.example.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.WishItemCellBinding

class WishItemViewHolder(
    private val context: Context,
    private val binding: WishItemCellBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bindWishItem(wishItem: WishItem){
        binding.name.text = wishItem.name
        binding.url.text= wishItem.url
        binding.price.text = wishItem.price
    }
}