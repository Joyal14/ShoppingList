package com.example.shoppinglistapplication.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.shoppinglistapplication.data.ShoppingDAO
import com.example.shoppinglistapplication.data.ShoppingItem

class ShoppingRepository(private val shoppingDAO: ShoppingDAO) {
    val allShoppingList:LiveData<List<ShoppingItem>> = shoppingDAO.getAllShopping()


    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(shoppingItem: ShoppingItem) {
        shoppingDAO.insert(shoppingItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(shoppingItem: ShoppingItem) {
        shoppingDAO.update(shoppingItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(shoppingItem: ShoppingItem) {
        shoppingDAO.delete(shoppingItem)
    }
}