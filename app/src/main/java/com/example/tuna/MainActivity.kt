package com.example.tuna

import FoodClass.Foodarr
import MainSystem.*
import android.content.Intent
import android.icu.util.Output
import android.os.Bundle
import android.text.InputType
import android.util.Log

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.PrintWriter
import java.net.Socket

class MainActivity : AppCompatActivity(),deleteListItem,send{
    var arr:Array<TextView?> = arrayOf()
    override var NowList: Array<TextView?> = arrayOf()
    var e:String?=null
    override var ThisTableNumber:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a=intent.getStringExtra("A")
        var b=intent.getStringExtra("B")
        var c=intent.getStringExtra("C")
        var d=intent.getStringExtra("D")
        e=intent.getStringExtra("E")
        CheckNull(A,B,C,D,a,b,c,d)
        if(a==null)
        {
            Thread{
                var ThisClient=Socket("192.168.1.101",5004)
                val input = ThisClient!!.getInputStream()
                val reader = BufferedReader(InputStreamReader(input))
                val output = ThisClient.getOutputStream()
                var writer = PrintWriter(output, true)
                writer.println(true)
                e=reader.readLine()
                TableNumber.text=e
            }.start()
        }
        TableNumber.text=e
        ThisTableNumber=e
        arr=arrayOf(A,B,C,D)
        updata(arr)

    }

    override fun onBackPressed() {


    }

    fun D1(view:View)
    {
        delete(A, Foodarr)
    }
    fun D2(view:View)
    {
        delete(B,Foodarr)
    }
    fun D3(view:View)
    {
        delete(C,Foodarr)
    }
    fun D4(view:View)
    {
        delete(D, Foodarr)
    }

    fun ToNoodles(view:View)
    {
        val intent = Intent(this@MainActivity, NoodlesMenu::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)
    }

    fun ToRice(view:View)
    {
        val intent = Intent(this@MainActivity, RiceMenu::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)
    }
    fun ToSoup(view:View)
    {
        val intent = Intent(this@MainActivity, SoupMenu::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)
    }
    fun ToDrink(view:View)
    {
        val intent = Intent(this@MainActivity, DrinkMenu::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)
    }

    fun ToLightFood(view:View)
    {
        val intent = Intent(this@MainActivity, LightFoodMenu::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)
    }
    fun ToDessert(view:View)
    {
        val intent = Intent(this@MainActivity, DessertMenu::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)
    }
}
