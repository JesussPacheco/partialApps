package com.example.applistproducts.models

import com.google.gson.annotations.SerializedName

class ApiResponseDetails (
    @SerializedName("results")
    val results: Int,

    @SerializedName("products")
    val products: List<Product> //import.
)