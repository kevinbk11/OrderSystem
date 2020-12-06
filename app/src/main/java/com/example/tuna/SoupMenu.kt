package com.example.tuna

import FoodClass.Foodarr
import MainSystem.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_soup_menu.*

class SoupMenu : AppCompatActivity(), deleteListItem,send {
    var arr:Array<TextView?> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soup_menu)

        arr = arrayOf(A2,B2,C2,D2)
        recive(arr,intent)
        toast = Toast.makeText(applicationContext, full, Toast.LENGTH_LONG)
    }
    override fun onBackPressed() {
        var intent= Intent(this,MainActivity::class.java)
        SendTextToActivity(A2,B2,C2,D2,intent)
        startActivity(intent) 
    }
    fun D1(view: View)
    {
        delete(A2, Foodarr)
    }
    fun D2(view: View)
    {
        delete(B2, Foodarr)
    }
    fun D3(view: View)
    {
        delete(C2, Foodarr)
    }
    fun D4(view: View)
    {
        delete(D2, Foodarr)
    }

    fun make1(view: View)
    {
        Foodarr["Soup1"]?.append(arr, toast)
    }
    fun make2(view: View)
    {
        Foodarr["Soup2"]?.append(arr, toast)
    }
    fun make3(view: View)
    {
        Foodarr["Soup3"]?.append(arr, toast)
    }
    fun make4(view: View)
    {
        Foodarr["Soup4"]?.append(arr, toast)
    }
    fun make5(view: View)
    {
        Foodarr["Soup5"]?.append(arr, toast)
    }
    fun make6(view: View)
    {
        Foodarr["Soup6"]?.append(arr, toast)
    }

}