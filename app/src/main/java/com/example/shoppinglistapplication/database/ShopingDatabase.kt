package com.example.shoppinglistapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglistapplication.data.ShoppingDAO
import com.example.shoppinglistapplication.data.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShopingDatabase : RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDAO
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ShopingDatabase? = null

        fun getDatabase(context: Context): ShopingDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShopingDatabase::class.java,
                    "shoppindDB.db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}