package com.example.tdd_mvvm.ui.twoFragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tdd_mvvm.R
import com.example.tdd_mvvm.core.BaseFragment
import com.example.tdd_mvvm.databinding.TwoBinding
import com.example.tdd_mvvm.utils.afterTextChanged
import kotlinx.android.synthetic.main.two_fragment.view.*

class TwoFragment : BaseFragment() {
    lateinit var binding : TwoBinding
    lateinit var viewModel: TwoViewModel

    companion object {
        fun newInstance(): TwoFragment {
            val args = Bundle()
            val fragment = TwoFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.two_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(TwoViewModel::class.java)
        binding.vm = viewModel
        val view = binding!!.root

        view.leftText.afterTextChanged {
            val value = if(it?.toString()?.isNotBlank() == true) it.toString().toInt() else 0
            viewModel.setLeftOperand(value)
        }
        view.rightText.afterTextChanged {
            val value = if(it?.toString()?.isNotBlank() == true) it.toString().toInt() else 0
            viewModel.setRightOperand(value)
        }
        viewModel.plusMediator.observe(this, Observer {
            view.result.text = it.toString()
        })

        /*var recyclerView = view.rootView.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)*/

        return view
    }


}