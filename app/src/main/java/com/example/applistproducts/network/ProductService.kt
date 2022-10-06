package com.example.applistproducts.network

import com.example.applistproducts.models.ApiResponseHeader
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ProductService {
    @GET("search")
    fun getProducts(@Query("query") product: String,
    @Query("number") number: Int,
    @Query("apiKey") apiKey : String) : Call<ApiResponseHeader>
}