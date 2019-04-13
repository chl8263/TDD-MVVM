package com.example.tdd_mvvm.ui.mainActivity

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.util.Log

object NavigationBindingAdapter {

    @JvmStatic
    @BindingAdapter("setOnNavigationItemSelected")
    fun setOnNavigationItemSelectedListener(view : BottomNavigationView, listener: BottomNavigationView.OnNavigationItemSelectedListener?){
        Log.e("aa",this.javaClass.name)
        if(listener != null){
            view.setOnNavigationItemSelectedListener(listener)
        }else{
            Log.e("NaviBindingAdapter","listener null")
        }
    }

    @JvmStatic
    @BindingAdapter("setInitItemId")
    fun setInitItemId(view: BottomNavigationView, itemId: Int){
        view.selectedItemId = itemId
    }
}