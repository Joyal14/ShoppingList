package com.example.shoppinglistapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistapplication.data.ShoppingItem
import com.example.shoppinglistapplication.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository): ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val getAllShopping: LiveData<List<ShoppingItem>> = repository.allShoppingList

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(shoppingItem: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(shoppingItem)
    }
    fun delete(shoppingItem: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(shoppingItem)
    }
    fun update(shoppingItem: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.update(shoppingItem)
    }
}
class ShoppingViewModelFactory(private val repository: ShoppingRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoppingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShoppingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}