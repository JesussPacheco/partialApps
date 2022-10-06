package com.example.appfutbolperu.models

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

    @SerializedName("name")
    val name: String,

    @SerializedName("logo")
    val logo: String,

    @SerializedName("venue_name")
    val venueName: String
): Serializable