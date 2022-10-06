package com.example.applistproducts.controller.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.applistproducts.R
import com.example.applistproducts.database.ProductDB
import com.example.applistproducts.models.Product
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class ProductDetail : AppCompatActivity() {
    lateinit var ivLogoDetail: ImageView
    lateinit var tvNameDetail: TextView
    lateinit var tvVenueName: TextView
    lateinit var fabSave: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        ivLogoDetail = findViewById(R.id.ivLogoDetail)
        tvNameDetail = findViewById(R.id.tvNameDetail)
        tvVenueName = findViewById(R.id.tbVenueName)
        fabSave = findViewById(R.id.fabSave)

        initFields(this)
    }

    private fun initFields(context: Context) {
        val productObject: Product? = intent.getSerializableExtra("Product") as Product?

        val picBuilder = Picasso.Builder(context)
        picBuilder.downloader(OkHttp3Downloader(context))
        picBuilder.build().load(productObject?.image).into(ivLogoDetail)

        tvNameDetail.text = productObject?.title
        tvVenueName.text = productObject?.venueName

        fabSave.setOnClickListener {
            saveProduct(productObject)
            finish()
        }

    }

    private fun saveProduct(productObject: Product?) {
        if (productObject != null){
            ProductDB.getInstance(this).getProductDAO().insertProduct(productObject)
        }
    }
}