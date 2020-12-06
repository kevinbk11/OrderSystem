package com.example.tuna

import FoodClass.Foodarr
import MainSystem.*
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dessert_menu.*


class DessertMenu : AppCompatActivity(), deleteListItem,send{

    var arr:Array<TextView?> = arrayOf()
    override var NowList: Array<TextView?> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert_menu)

        arr = arrayOf(A4,B4,C4,D4)
        recive(arr,intent)
        toast = Toast.makeText(applicationContext, full, Toast.LENGTH_LONG)
        updata(arr)
    }
    override fun onBackPressed() {
        var intent= Intent(this,MainActivity::class.java)
        SendTextToActivity(A4,B4,C4,D4,intent)
        startActivity(intent)
    }
    fun D1(view: View)
    {
        delete(A4, Foodarr)
    }
    fun D2(view: View)
    {
        delete(B4, Foodarr)
    }
    fun D3(view: View)
    {
        delete(C4, Foodarr)
    }
    fun D4(view: View)
    {
        delete(D4, Foodarr)
    }

    fun make1(view:View)
    {
        Foodarr["Dessert1"]?.append(arr, toast)
    }
    fun make2(view:View)
    {
        Foodarr["Dessert2"]?.append(arr, toast)
    }
    fun make3(view:View)
    {
        Foodarr["Dessert3"]?.append(arr, toast)
    }
    fun make4(view:View)
    {
        Foodarr["Dessert4"]?.append(arr, toast)
    }
    fun make5(view:View)
    {
        Foodarr["Dessert5"]?.append(arr, toast)
    }
    fun make6(view:View)
    {
        Foodarr["Dessert6"]?.append(arr, toast)
    }
    fun make7(view:View)
    {
        Foodarr["Dessert7"]?.append(arr, toast)
    }
    fun make8(view:View)
    {
        Foodarr["Dessert8"]?.append(arr, toast)
    }
}