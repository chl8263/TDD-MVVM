package com.example.tdd_mvvm.ui.oneFragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tdd_mvvm.R
import com.example.tdd_mvvm.core.BaseFragment
import com.example.tdd_mvvm.databinding.OneBinding
import kotlinx.android.synthetic.main.one_fragment.*
import kotlinx.android.synthetic.main.one_fragment.view.*

class OneFragment : BaseFragment() {
    lateinit var binding : OneBinding
    lateinit var viewModel: OneViewModel

    companion object {
        fun newInstance(): OneFragment {
            val args = Bundle()
            val fragment = OneFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.one_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(OneViewModel::class.java)
        binding.vm = viewModel
        val view = binding!!.root

        view.rootView.recyclerView.layoutManager =LinearLayoutManager(context)

        return view
    }


}