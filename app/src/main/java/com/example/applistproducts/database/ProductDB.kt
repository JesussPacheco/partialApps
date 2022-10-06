package com.example.applistproducts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applistproducts.models.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDB : RoomDatabase() {
    abstract fun getProductDAO() : ProductDAO

    companion object {

        private var INSTANCE : ProductDB?= null
        fun getInstance(context: Context) : ProductDB {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, ProductDB::class.java, "product.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as ProductDB
        }
    }
}