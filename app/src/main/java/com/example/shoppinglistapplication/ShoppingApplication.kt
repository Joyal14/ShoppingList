package com.example.shoppinglistapplication

import android.app.Application

class ShoppingApplication:Application() {

    val database by lazy { ShopingDatabase.getDatabase(this) }
    val repository by lazy { ShoppingRepository(database.shoppingDao()) }
}