package com.example.recyclerview


import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerview.databinding.FragmentNewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NewTaskSheet(var wishItem: WishItem?): BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var wishListViewModel: WishListViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if(wishItem != null){
            binding.wishTitle.text = "Edit Wish"
            val editable = Editable.Factory.getInstance()
            binding.itemName.text = editable.newEditable(wishItem!!.name)
            binding.itemURL.text = editable.newEditable(wishItem!!.url)
            binding.itemPrice.text = editable.newEditable(wishItem!!.price)
        }
        else{
            binding.wishTitle.text = "New Wish"
        }
        wishListViewModel = ViewModelProvider(activity).get(WishListViewModel::class.java)
        binding.saveButton.setOnClickListener{
            saveAction()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNewTaskSheetBinding.inflate(inflater,container, false)
        return binding.root
    }

    private fun saveAction(){
        var name = binding.itemName.text.toString()
        var url  = binding.itemURL.text.toString()
        var price = binding.itemPrice.text.toString()
        if(wishItem == null){
            val newWishItem = WishItem(name, url, price)
            wishListViewModel.addWishItem(newWishItem)
        }else{
            wishListViewModel.updateWishItem(wishItem!!.id, name, url, price)
        }
        binding.itemName.setText("")
        binding.itemURL.setText("")
        binding.itemPrice.setText("")
        dismiss()


    }
}