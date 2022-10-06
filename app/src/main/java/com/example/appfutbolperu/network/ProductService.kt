package com.example.appfutbolperu.network

import com.example.appfutbolperu.models.ApiResponseHeader
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ProductService {
    @GET("50")
    fun getProducts(@Header("x-rapidapi-host")host: String,
    @Header("x-rapidapi-key")apiKey: String): Call<ApiResponseHeader>
}