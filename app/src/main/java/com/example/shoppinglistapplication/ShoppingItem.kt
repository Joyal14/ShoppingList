package com.example.shoppinglistapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_list")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    val name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
