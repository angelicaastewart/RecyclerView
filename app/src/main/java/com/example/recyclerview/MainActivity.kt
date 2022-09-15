package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var wishlistviewModel: WishListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        wishlistviewModel = ViewModelProvider(this).get(WishListViewModel::class.java)
        binding.newTaskButton.setOnClickListener{
            NewTaskSheet(null).show(supportFragmentManager, "newWishTag")
        }

        setRecyclerView()

    }
    private fun setRecyclerView(){
        val mainActivity = this
        wishlistviewModel.wishItems.observe(this){
            binding.wishListRecyclerView.apply{
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = WishItemAdapter(it)
            }
        }
    }
}