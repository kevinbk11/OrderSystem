package com.example.tuna

import FoodClass.Foodarr
import MainSystem.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import java.time.LocalTime

class MainActivity : AppCompatActivity(),deleteListItem,send,WaitReturn{
    var arr:Array<TextView?> = arrayOf()
    override var app: Context?=null
    override var NowList: Array<TextView?> = arrayOf()
    var e:String?=null
    override var ThisTableNumber:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app=applicationContext
        var a=intent.getStringExtra("A")
        var b=intent.getStringExtra("B")
        var c=intent.getStringExtra("C")
        var d=intent.getStringExtra("D")//第一次運行時為null 其餘時間非None就是餐點名稱
        e=intent.getStringExtra("E")
        CheckNull(A,B,C,D,a,b,c,d)
        Log.v("test",e.toString())
        if(a==null && e==null)
        {
            Thread{
                var ThisClient=Socket(ip,5004)
                val input = ThisClient!!.getInputStream()
                val reader = BufferedReader(InputStreamReader(input))
                val output = ThisClient.getOutputStream()
                var writer = PrintWriter(output, true)
                writer.println(0)
                e=reader.readLine()
                TableNumber.text=e
            }.start()
        }
        else if(a==null && e!=null)
        {
            A.text="None"
            B.text="None"
            C.text="None"
            D.text="None"
        }
        sendToast= Toast.makeText(app,sended,Toast.LENGTH_SHORT)
        while(e==null)
        {

        }
        waitReturn(e,app, sendToast)
        TableNumber.text=e
        ThisTableNumber=e
        arr=arrayOf(A,B,C,D)
        updata(arr)
    }

    override fun onBackPressed() {



    }
    fun Check(view:View)
    {
        val intent=Intent(this@MainActivity, FoodRecord::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)
    }
    fun end(view:View)
    {
        val builder = AlertDialog.Buildger(this)
        builder.setTitle("結帳")
            .setCancelable(false)
            .setPositiveButton("確定",DialogInterface.OnClickListener{dialog,i->
                val intent = Intent(this@MainActivity, EndEat::class.java)
                val bundle=Bundle()
                bundle.putString("tableNumber",e)
                intent.putExtras(bundle)
                startActivity(intent)
            })
            .setNeutralButton("取消",DialogInterface.OnClickListener{dialog,i->

            })
        builder.show()
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
    fun ToFfd(view:View)
    {
        val intent = Intent(this@MainActivity, FfdMemu::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)
    }
}