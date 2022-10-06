package com.example.applistproducts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applistproducts.R
import com.example.applistproducts.models.Product
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.prototype_product.view.*

class ProductAdapter(val products: List<Product>, val context: Context, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val ivLogo = view.ivLogo
        val tvName = view.tvName
        val cvProduct = view.cvProduct
    }

    interface OnItemClickListener {
        fun onItemClicked(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.prototype_product, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val product = products[position]
        holder.tvName.text = product.name

        val picBuilder = Picasso.Builder(context)
        picBuilder.downloader(OkHttp3Downloader(context))
        picBuilder.build().load(product.logo).into(holder.ivLogo)

        holder.cvProduct.setOnClickListener {
            itemClickListener.onItemClicked(product)
        }
    }
}