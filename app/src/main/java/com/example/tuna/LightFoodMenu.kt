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
import kotlinx.android.synthetic.main.activity_light_food_menu.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class LightFoodMenu : AppCompatActivity(), deleteListItem,send,WaitReturn{
    override var app: Context?=null
    var arr:Array<TextView?> = arrayOf()
    override var ThisTableNumber:String?=null
    var e:String?=null
    override var NowList: Array<TextView?> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_food_menu)

        arr = arrayOf(A3,B3,C3,D3)
        app=applicationContext


        toast = Toast.makeText(applicationContext, full, Toast.LENGTH_LONG)
        recive(arr,intent)

        e=intent.getStringExtra("E")
        updata(arr)
        ThisTableNumber=e
        sendToast= Toast.makeText(app,sended,Toast.LENGTH_SHORT)
        waitReturn(e,app, sendToast)
    }
    override fun onBackPressed() {
        var intent= Intent(this,MainActivity::class.java)
        SendTextToActivity(A3,B3,C3,D3,e,intent)
        startActivity(intent)
    }
    fun D1(view: View)
    {
        delete(A3, Foodarr)
    }
    fun D2(view: View)
    {
        delete(B3, Foodarr)
    }
    fun D3(view: View)
    {
        delete(C3, Foodarr)
    }
    fun D4(view: View)
    {
        delete(D3, Foodarr)
    }

    fun make1(view:View)
    {
        Foodarr["LightFood1"]?.append(arr, toast)
    }
    fun make2(view:View)
    {
        Foodarr["LightFood2"]?.append(arr, toast)
    }
    fun make3(view:View)
    {
        Foodarr["LightFood3"]?.append(arr, toast)
    }
    fun make4(view:View)
    {
        Foodarr["LightFood4"]?.append(arr, toast)
    }
    fun make5(view:View)
    {
        Foodarr["LightFood5"]?.append(arr, toast)
    }
    fun make6(view:View)
    {
        Foodarr["LightFood6"]?.append(arr, toast)
    }
    fun make7(view:View)
    {
        Foodarr["LightFood7"]?.append(arr, toast)
    }
    fun make8(view:View)
    {
        Foodarr["LightFood8"]?.append(arr, toast)
    }
}