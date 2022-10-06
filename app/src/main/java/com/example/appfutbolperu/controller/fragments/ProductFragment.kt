package com.example.appfutbolperu.controller.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfutbolperu.R
import com.example.appfutbolperu.adapter.ProductAdapter
import com.example.appfutbolperu.controller.activities.ProductDetail
import com.example.appfutbolperu.models.ApiResponseHeader
import com.example.appfutbolperu.models.Product
import com.example.appfutbolperu.network.ProductService
import kotlinx.android.synthetic.main.fragment_product.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductFragment : Fragment(), ProductAdapter.OnItemClickListener {
    var product: List<Product> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = rvProducts
        loadProducts(view.context)
    }

    private fun loadProducts(context: Context) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/v2/products/league/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val productService: ProductService
        productService = retrofit.create(ProductService::class.java)

        val request = productService.getProducts(
            "api-football-v1.p.rapidapi.com",
            "d229813befmsh4c1646ad132a0b5p1313fcjsn9afecaefc97e")

        request.enqueue(object : Callback<ApiResponseHeader> {
            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                Log.d("Activity Fail", "Error: "+t.toString())
            }

            override fun onResponse(call: Call<ApiResponseHeader>, responseDetails: Response<ApiResponseHeader>) {
                if (responseDetails.isSuccessful) {
                    val products: List<Product> = responseDetails.body()!!.api.products ?: ArrayList()
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = ProductAdapter(products, context, this@ProductFragment)
                }

                else{
                    Log.d("Activity Fail", "Error: "+responseDetails.code())
                }
            }
        })
    }

    override fun onItemClicked(product: Product) {
        val intent = Intent(context, ProductDetail::class.java)
        intent.putExtra("Product", product)
        startActivity(intent)
    }
}