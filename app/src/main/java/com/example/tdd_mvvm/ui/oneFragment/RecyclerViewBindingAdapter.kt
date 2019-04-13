package com.example.tdd_mvvm.ui.oneFragment

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.RecyclerView
import android.util.Log

object RecyclerViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind_item")
    fun bind_item(view : RecyclerView, list : ArrayList<ItemVO>){

        val adapter = view.adapter ?: ItemAdapter(list).apply { view.adapter = this }

        adapter.notifyDataSetChanged()
    }
}