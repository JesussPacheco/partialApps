package com.example.appfutbolperu.database

import androidx.room.*
import com.example.appfutbolperu.models.Product

@Dao
interface ProductDAO {
    @Insert
    fun insertProduct(vararg product: Product)

    @Query("SELECT * FROM products ")
    fun getAllProducts(): List<Product>

    @Delete
    fun deleteProducts(vararg product: Product)

    @Update
    fun updateProducts(vararg product: Product)
}