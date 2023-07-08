package com.example.shoppinglistapplication.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistapplication.ShoppingApplication
import com.example.shoppinglistapplication.Adapter.ShoppingItemAdapter
import com.example.shoppinglistapplication.viewmodel.ShoppingViewModel
import com.example.shoppinglistapplication.viewmodel.ShoppingViewModelFactory
import com.example.shoppinglistapplication.data.ShoppingItem
import com.example.shoppinglistapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ShoppingViewModel
    private lateinit var binding: ActivityMainBinding


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //View model first

        val viewModelFactory = ShoppingViewModelFactory((application as ShoppingApplication).repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[ShoppingViewModel::class.java]

        //later adapter
        val adapter = ShoppingItemAdapter(viewModel)
        binding.rvItemList.layoutManager = LinearLayoutManager(this)
        binding.rvItemList.adapter = adapter


        viewModel.getAllShopping.observe(this, Observer {

            adapter.item.size
            adapter.item = it
            adapter.notifyDataSetChanged()
        })
        binding.fab.setOnClickListener {
            AddShoppingItemDialog(this,
            object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.insert(item)
                }
            }).show()
        }
    }
}