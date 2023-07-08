package com.example.shoppinglistapplication

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglistapplication.databinding.ActivityMainBinding
import com.example.shoppinglistapplication.databinding.AddItemBinding


class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener):AppCompatDialog(context) {

    private lateinit var binding: AddItemBinding
//    val add = findViewById<Button>(R.id.btn_add)
//    val remove =findViewById<Button>(R.id.btn_cancel)
//    val name = findViewById<EditText>(R.id.edt_name)
//    private val amount = findViewById<EditText>(R.id.edt_amount)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            val name = binding.edtName.text.toString()
            val amount = binding.edtAmount.text.toString().toInt()
            if (name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name,amount)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        binding.btnCancel.setOnClickListener {
            cancel()
        }
    }
}