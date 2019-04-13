package com.example.tdd_mvvm.ui.mainActivity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.util.Log
import com.example.tdd_mvvm.R
import com.example.tdd_mvvm.core.BaseActivity
import com.example.tdd_mvvm.databinding.MainBinding
import com.example.tdd_mvvm.ui.oneFragment.OneFragment
import com.example.tdd_mvvm.ui.twoFragment.TwoFragment

class MainActivity : BaseActivity() {

    lateinit var binding : MainBinding
    lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("aa","1")
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.vm = vm

        vm.setNavigationItemSelectedListener(navigationSelectedListener)

        Log.e("aa","2")

    }

    fun replaceFragment(fragment : Fragment){
        var ft : FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragmentcontainer,fragment).commit()
    }

    var navigationSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        menuItem ->

        when(menuItem.itemId){
            R.id.one -> {
                replaceFragment(OneFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.two -> {
                replaceFragment(TwoFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }

            else -> false
        }
        return@OnNavigationItemSelectedListener false
    }
}
