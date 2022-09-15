package com.example.recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class WishListViewModel: ViewModel() {
    var wishItems =  MutableLiveData<MutableList<WishItem>>()

    init{
        wishItems.value = mutableListOf()
    }

    fun addWishItem(newWish: WishItem){
        val list = wishItems.value
        list!!.add(newWish)
        wishItems.postValue(list)
    }

    fun updateWishItem(id: UUID, name: String, url: String, price: String){
        val list = wishItems.value
        val wish = list!!.find{it.id == id}!!
        wish.name = name
        wish.url = url
        wish.price = price
        wishItems.postValue(list)
    }







}