package com.example.applistproducts.controller.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applistproducts.R
import com.example.applistproducts.adapter.ProductAdapter
import com.example.applistproducts.database.ProductDB
import com.example.applistproducts.models.Product
import kotlinx.android.synthetic.main.fragment_save.view.*

class SaveFragment : Fragment(), ProductAdapter.OnItemClickListener {
    var product: List<Product> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save, container, false)
    }

    //Ctrl + O
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product = ProductDB.getInstance(view.context).getProductDAO().getAllProducts()
        recyclerView = view.rvProductSave
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProductAdapter(product, view.context, this)
    }

    override fun onItemClicked(product: Product) {
        TODO("Not yet implemented")
    }
}