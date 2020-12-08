package com.example.tuna

import FoodClass.Foodarr
import MainSystem.*
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_noodles_menu.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class RiceMenu : AppCompatActivity(), deleteListItem,send {
    var arr:Array<TextView?> = arrayOf()


    override var NowList: Array<TextView?> = arrayOf()
    var e:String?=null
    override var ThisTableNumber:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rice_menu)

        arr = arrayOf(A1,B1,C1,D1)

        recive(arr,intent)

        e=intent.getStringExtra("E")
        toast = Toast.makeText(applicationContext, full, Toast.LENGTH_LONG)

        ThisTableNumber=e

        updata(arr)

        Thread{
            var ThisClient=Socket("192.168.1.101",5006)
            Log.v("connect","success")
            val input = ThisClient!!.getInputStream()
            val reader = BufferedReader(InputStreamReader(input))
            val output = ThisClient.getOutputStream()
            var writer = PrintWriter(output, true)
            while(e==null)
            {
                Thread.sleep(1000)
            }
            writer.println(e)
            while(true)
            {
                Log.v("test",reader.readLine())
            }

        }.start()
    }

    override fun onBackPressed() {
        var intent= Intent(this,MainActivity::class.java)
        SendTextToActivity(A1,B1,C1,D1,e,intent)
        startActivity(intent)
    }
    fun D1(view: View)
    {
        delete(A1, Foodarr)
    }
    fun D2(view: View)
    {
        delete(B1, Foodarr)
    }
    fun D3(view: View)
    {
        delete(C1, Foodarr)
    }
    fun D4(view: View)
    {
        delete(D1, Foodarr)
    }

    fun make1(view:View)
    {
        Foodarr["Rice1"]?.append(arr,toast)
    }
    fun make2(view:View)
    {
        Foodarr["Rice2"]?.append(arr,toast)
    }
    fun make3(view:View)
    {
        Foodarr["Rice3"]?.append(arr,toast)
    }
    fun make4(view:View)
    {
        Foodarr["Rice4"]?.append(arr,toast)
    }
    fun make5(view:View)
    {
        Foodarr["Rice5"]?.append(arr,toast)
    }
    fun make6(view:View)
    {
        Foodarr["Rice6"]?.append(arr,toast)
    }
    fun make7(view:View)
    {
        Foodarr["Rice7"]?.append(arr,toast)
    }
    fun make8(view:View)
    {
        Foodarr["Rice8"]?.append(arr,toast)
    }
    fun make9(view:View)
    {
        Foodarr["Rice9"]?.append(arr,toast)
    }
    fun make10(view:View)
    {
        Foodarr["Rice10"]?.append(arr,toast)
    }

}