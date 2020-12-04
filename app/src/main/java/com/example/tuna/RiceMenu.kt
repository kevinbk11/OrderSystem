package com.example.tuna

import FoodClass.Foodarr
import MainSystem.full
import MainSystem.recive
import MainSystem.toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import deleteInterface.deleteListItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_noodles_menu.*

class RiceMenu : AppCompatActivity(),deleteListItem {
    var arr:Array<TextView?> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rice_menu)

        arr = arrayOf(A1,B1,C1,D1)
        recive(arr,intent)
        toast = Toast.makeText(applicationContext, full, Toast.LENGTH_LONG)

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