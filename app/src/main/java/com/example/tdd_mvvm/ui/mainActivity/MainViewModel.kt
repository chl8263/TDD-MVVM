package com.example.tdd_mvvm.ui.mainActivity

import android.arch.lifecycle.ViewModel
import android.support.design.widget.BottomNavigationView

class MainViewModel : ViewModel(){

    var mNavigationItemSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener? = null

    fun setNavigationItemSelectedListener (mNavigationItemSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener) {
        this.mNavigationItemSelectedListener = mNavigationItemSelectedListener
    }
}