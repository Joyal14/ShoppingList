package com.example.shoppinglistapplication

import android.app.Application
import com.example.shoppinglistapplication.database.ShopingDatabase
import com.example.shoppinglistapplication.repository.ShoppingRepository

class ShoppingApplication:Application() {

    private val database by lazy { ShopingDatabase.getDatabase(this) }
    val repository by lazy { ShoppingRepository(database.shoppingDao()) }
}