package com.example.tuna

import FoodClass.Foodarr
import MainSystem.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_soup_menu.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class SoupMenu : AppCompatActivity(), deleteListItem,send ,WaitReturn{
    override var app: Context?=null
    var arr:Array<TextView?> = arrayOf()
    override var ThisTableNumber:String?=null
    var e:String?=null
    override var NowList: Array<TextView?> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soup_menu)

        arr = arrayOf(A2,B2,C2,D2)
        app=applicationContext
        recive(arr,intent)

        e=intent.getStringExtra("E")

        toast = Toast.makeText(applicationContext, full,Toast.LENGTH_SHORT)
        updata(arr)
        ThisTableNumber=e
        sendToast= Toast.makeText(app,sended,Toast.LENGTH_LONG)
        waitReturn(e,app, sendToast)
    }
    override fun onBackPressed() {
        var intent= Intent(this,MainActivity::class.java)
        SendTextToActivity(A2,B2,C2,D2,e,intent)
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