package com.example.tdd_mvvm.ui.twoFragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.databinding.ObservableInt
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

class TwoViewModel : ViewModel() {

    private val leftOperand = MutableLiveData<Int>()
    private val rightOperand = MutableLiveData<Int>()

    private val _plusMediator = MediatorLiveData<Int>()
    val plusMediator : LiveData<Int>
        get() = _plusMediator

    init {
        _plusMediator.addSource(leftOperand){   //onChanged 람다식으로 대체
            _plusMediator.value = plusOperands()
        }
        _plusMediator.addSource(rightOperand){
            _plusMediator.value = plusOperands()
        }
    }

    private fun plusOperands() : Int = (leftOperand.value ?: 0) + (rightOperand.value ?: 0)

    fun setLeftOperand (value : Int){
        leftOperand.value = value
    }
    fun setRightOperand (value : Int){
        rightOperand.value = value
    }
}