package com.example.applistproducts.database

import androidx.room.*
import com.example.applistproducts.models.Product

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