package com.example.shoppinglistapplication.ui

import com.example.shoppinglistapplication.data.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}