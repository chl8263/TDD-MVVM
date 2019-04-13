package com.example.tdd_mvvm.ui.oneFragment

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList

class OneViewModel : ViewModel() {

    var itemList = ObservableArrayList<ItemVO>()

    fun onAddItem(){
        itemList.add(ItemVO(System.currentTimeMillis().toString()))
    }

    fun onDeleteItem(){
        if(itemList.size !=0) itemList.removeAt(itemList.size-1)
    }
}