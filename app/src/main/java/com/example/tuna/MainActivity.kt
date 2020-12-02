package com.example.tuna

import FoodClass.*
import MainSystem.CheckNull
import MainSystem.SendTextToActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import deleteInterface.deleteListItem

class MainActivity : AppCompatActivity(),deleteListItem{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a=intent.getStringExtra("A")
        var b=intent.getStringExtra("B")
        var c=intent.getStringExtra("C")
        CheckNull(A,B,C,a,b,c)
        /*val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("輸入桌號")
        val input = EditText(this)
        var tableNumber =input.text.toString()
        alertDialog.setView(input)
        alertDialog.setCancelable(false)
                .setPositiveButton("確定", DialogInterface.OnClickListener { _, _ ->
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

    fun next(view:View)
    {
        val intent = Intent(this@MainActivity, NoodlesMenu::class.java)
        SendTextToActivity(A,B,C,intent)
        startActivity(intent)
    }
}
