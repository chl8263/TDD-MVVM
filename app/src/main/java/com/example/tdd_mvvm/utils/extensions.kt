package com.example.tdd_mvvm.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

inline fun EditText.afterTextChanged (crossinline block : (editable : Editable) -> Unit){

    this.addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            p0?.let { block.invoke(it) }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    })
}