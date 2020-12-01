package com.example.tuna

import FoodClass.Food
import FoodClass.Foodarr
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
        /*val bundle = intent.extras
        var S=bundle?.getString("num")
        A.text=S*/
    }
    val toast=Toast.makeText(applicationContext,"購物車已滿!請刪除其他食物", Toast.LENGTH_LONG)

    fun make1(view: View)
    {
        var arr = arrayOf(A,B,C)
        Foodarr["Noodle1"]!!.append(arr,toast)
    }
    fun make2(view: View)
    {
        var arr = arrayOf(A,B,C)
        Foodarr["Noodle2"]!!.append(arr,toast)
    }
    fun make3(view: View)
    {
        var arr = arrayOf(A,B,C)
        Foodarr["Noodle3"]!!.append(arr,toast)
    }
    fun make4(view: View)
    {
        var arr = arrayOf(A,B,C)
        Foodarr["Noodle4"]!!.append(arr,toast)
    }
    fun make5(view: View)
    {
        var arr = arrayOf(A,B,C)
        Foodarr["Noodle5"]!!.append(arr,toast)
    }
    fun make6(view: View)
    {
        var arr = arrayOf(A,B,C)
        Foodarr["Noodle6"]!!.append(arr,toast)
    }
    fun make7(view: View)
    {
        var arr = arrayOf(A,B,C)
        Foodarr["Noodle7"]!!.append(arr,toast)
    }
    fun D1(view: View)
    {
        var arr = arrayOf(A,B,C)
        delete(arr[0], Foodarr)
    }
    fun D2(view: View)
    {
        var arr = arrayOf(A,B,C)
        delete(arr[1], Foodarr)
    }
    fun D3(view: View)
    {
        var arr = arrayOf(A,B,C)
        delete(arr[2], Foodarr)
    }
}
