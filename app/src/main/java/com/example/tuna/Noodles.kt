package com.example.tuna

import FoodClass.Noodles.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import deleteInterface.deleteListItem
import kotlinx.android.synthetic.main.activity_main.*

class Noodles : AppCompatActivity(),deleteListItem {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noodles)
        val bundle = intent.extras
        var S=bundle?.getString("num")
        A.text=S
    }
    val toast=Toast.makeText(applicationContext,"購物車已滿!請刪除其他食物", Toast.LENGTH_LONG)
    var foodArr= arrayOf(Noodle_1,Noodle_2,Noodle_3,Noodle_4,Noodle_5,Noodle_6,Noodle_7)
    fun make1(view: View)
    {
        var arr = arrayOf(A,B,C)
        foodArr[0].append(arr,toast)
    }
    fun make2(view: View)
    {
        var arr = arrayOf(A,B,C)
        foodArr[1].append(arr,toast)
    }
    fun make3(view: View)
    {
        var arr = arrayOf(A,B,C)
        foodArr[2].append(arr,toast)

    }
    fun make4(view: View)
    {
        var arr = arrayOf(A,B,C)
        foodArr[3].append(arr,toast)

    }
    fun D1(view: View)
    {
        var arr = arrayOf(A,B,C)
        delete(arr[0])

    }
    fun D2(view: View)
    {
        var arr = arrayOf(A,B,C)
        delete(arr[1])
    }
    fun D3(view: View)
    {
        var arr = arrayOf(A,B,C)
        delete(arr[2])
    }
}
