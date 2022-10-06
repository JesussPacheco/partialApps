package com.example.applistproducts.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "products"
)
class Product (
    @PrimaryKey
    @SerializedName("product_id")
    val productId: Int = 0,

    @SerializedName("title")
    val title: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("image_type")
    val venueName: String
): Serializable