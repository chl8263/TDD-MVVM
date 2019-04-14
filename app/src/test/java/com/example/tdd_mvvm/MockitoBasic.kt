package com.example.tdd_mvvm

import android.util.Log
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.lang.RuntimeException
import java.util.*
import kotlin.collections.ArrayList

class MockitoBasic : Assert() {

    @Mock
    lateinit var list : ArrayList<String>

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun stub(){
        `when`(list.get(0)).thenReturn("hello")
        `when`(list.get(1)).thenReturn("1")

        verify(list).get(0)

        `when`(list.get(ArgumentMatchers.anyInt())).thenReturn("Int")

        list.get(0)

        verify(list).get(ArgumentMatchers.anyInt())   // mm 리스트에서 꺼낸적이 있냐.

        `when`(list.get(0)).thenReturn("a")


        Assert.assertEquals("a",list.get(0))
    }
    @Test
    fun verify(){
        list.add("1")
        list.add("2")
        list.add("2")
        list.add("3")

        verify(list).add("1")
        verify(list, times(1)).add("2") // 1번 호출이되었냐

        verify(list, never()).add("5")  // 호출된적이 없냐

        verify(list, atLeastOnce()).add("2")    //적어도 한번은 호출되었냐.

        verify(list , atLeast(2)).add("2")      //적어도 2번은 호출되었냐.

        verify(list, atMost(5)).add("2")    //적어도 5번이 호출 되었냐
    }

    @Test
    fun voidStub(){
        //`when`(list).clear()      //맞지 않은 문법
        doThrow(RuntimeException()).`when`(list).clear()       //때문에 Execption 을 던져서 사용한다.

        list.clear()



    }

}

