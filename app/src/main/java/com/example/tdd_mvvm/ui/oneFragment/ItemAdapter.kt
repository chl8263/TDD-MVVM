package com.example.tdd_mvvm.ui.oneFragment

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.tdd_mvvm.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class ItemAdapter (list: ArrayList<ItemVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var list = list

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.recycler_item,p0,false)

        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        p0.itemView.item_text.text = list[p1].name

        p0.itemView.item_delete.setOnClickListener {
            list.removeAt(p1)
        }
    }

    class CustomViewHolder (view : View) : RecyclerView.ViewHolder(view){

        var name : TextView
        var button : Button

        init {
            name = view.findViewById(R.id.item_text)
            button= view.findViewById(R.id.item_delete)
        }

    }

}