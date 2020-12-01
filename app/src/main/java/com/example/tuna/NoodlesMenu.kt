package com.example.tuna

import FoodClass.Foodarr
import MainSystem.SendTextToActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import deleteInterface.deleteListItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_noodles_menu.*
import org.w3c.dom.Text
import java.io.Serializable

class NoodlesMenu : AppCompatActivity(),deleteListItem {
    var arr:Array<TextView?> = arrayOf()
    var toast:Toast? = null
    val full="購物車已滿!請刪除其他食物"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noodles_menu)

        arr = arrayOf(A1,B1,C1)

        A1.text=intent.getStringExtra("A")
        B1.text=intent.getStringExtra("B")
        C1.text=intent.getStringExtra("C")

        toast=Toast.makeText(applicationContext,full,Toast.LENGTH_LONG)
    }

    fun make1(view: View)
    {
        Foodarr["Noodle1"]?.append(arr,toast)
    }
    fun make2(view: View)
    {
        Foodarr["Noodle2"]!!.append(arr,toast)
    }
    fun make3(view: View)
    {
        Foodarr["Noodle3"]!!.append(arr,toast)
    }
    fun make4(view: View)
    {
        Foodarr["Noodle4"]!!.append(arr,toast)
    }
    fun make5(view: View)
    {
        Foodarr["Noodle5"]!!.append(arr,toast)
    }
    fun make6(view: View)
    {
        Foodarr["Noodle6"]!!.append(arr,toast)
    }
    fun make7(view: View)
    {
        Foodarr["Noodle7"]!!.append(arr,toast)
    }
    fun D1(view: View)
    {
        delete(arr[0], Foodarr)
    }
    fun D2(view: View)
    {
        delete(arr[1], Foodarr)
    }
    fun D3(view: View)
    {
        delete(arr[2], Foodarr)
    }
    fun last(view:View)
    {
        val intent = Intent(this@NoodlesMenu, MainActivity::class.java)
        SendTextToActivity(A1,B1,C1,intent)
        startActivity(intent)
    }
}
