package com.example.tuna

import FoodClass.*
import MainSystem.CheckNull
import MainSystem.SendTextToActivity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import deleteInterface.deleteListItem
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class MainActivity : AppCompatActivity(),deleteListItem{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a=intent.getStringExtra("A")
        var b=intent.getStringExtra("B")
        var c=intent.getStringExtra("C")
        var d=intent.getStringExtra("D")
        CheckNull(A,B,C,D,a,b,c,d)

        Thread{
            val client=Socket("192.168.1.101",5004)
            val input = client?.getInputStream()
            val reader = BufferedReader(InputStreamReader(input))
            val output=client.getOutputStream()
            val writer = PrintWriter(output,true)
            var tableNumber=reader.readLine()
        }.start()

        /*if(a==null)
        {
            val alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("輸入桌號")
            val input = EditText(this)
            input.inputType=InputType.TYPE_CLASS_NUMBER
            alertDialog.setView(input)
            var tableNumber=""
            alertDialog.setCancelable(false)
            alertDialog.setPositiveButton("確定", DialogInterface.OnClickListener { _, _ ->
                    tableNumber =input.text.toString()
                    if(tableNumber.toInt()>8 || tableNumber.toInt()<0)
                    {
                        val s=alertDialog.create()
                        s.show()
                    }
                    else
                    {
                        Thread{
                            val client=Socket("192.168.1.101",5004)
                            val input = client?.getInputStream()
                            val reader = BufferedReader(InputStreamReader(input))
                            val output=client.getOutputStream()
                            val writer = PrintWriter(output,true)
                            writer?.println(tableNumber)
                        }.start()
                    }


                    /*val Client=connect()
                    Client.start()
                    Client.printToServer(tableNumber.toInt())*/
                })
            alertDialog.show()*/
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
        SendTextToActivity(A,B,C,D,intent)
        startActivity(intent)
    }

    fun ToRice(view:View)
    {
        val intent = Intent(this@MainActivity, RiceMenu::class.java)
        SendTextToActivity(A,B,C,D,intent)
        startActivity(intent)
    }
    fun ToSoup(view:View)
    {
        val intent = Intent(this@MainActivity, SoupMenu::class.java)
        SendTextToActivity(A,B,C,D,intent)
        startActivity(intent)
    }
    fun ToDrink(view:View)
    {
        val intent = Intent(this@MainActivity, DrinkMenu::class.java)
        SendTextToActivity(A,B,C,D,intent)
        startActivity(intent)
    }

    fun ToLightFood(view:View)
    {
        val intent = Intent(this@MainActivity, LightFoodMenu::class.java)
        SendTextToActivity(A,B,C,D,intent)
        startActivity(intent)
    }
    fun ToDessert(view:View)
    {
        val intent = Intent(this@MainActivity, DessertMenu::class.java)
        SendTextToActivity(A,B,C,D,intent)
        startActivity(intent)
    }
}
