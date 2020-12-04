package com.example.tuna

import FoodClass.Foodarr
import MainSystem.SendTextToActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.TextView
import deleteInterface.deleteListItem
import kotlinx.android.synthetic.main.activity_light_food_menu.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_soup_menu.*

class LightFoodMenu : AppCompatActivity(),deleteListItem {
    var arr:Array<TextView?> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_food_menu)
        arr=arrayOf(A3,B3,C3,D3)
    }
    override fun onBackPressed() {
        var intent= Intent(this,MainActivity::class.java)
        SendTextToActivity(A3,B3,C3,D3,intent)
        startActivity(intent)
    }
    fun D1(view: View)
    {
        delete(A, Foodarr)
    }
    fun D2(view: View)
    {
        delete(B, Foodarr)
    }
    fun D3(view: View)
    {
        delete(C, Foodarr)
    }
    fun D4(view: View)
    {
        delete(D, Foodarr)
    }

    fun make1(view:View)
    {

    }
    fun make2(view:View)
    {

    }
    fun make3(view:View)
    {

    }
    fun make4(view:View)
    {

    }
    fun make5(view:View)
    {

    }
    fun make6(view:View)
    {

    }
    fun make7(view:View)
    {

    }
    fun make8(view:View)
    {

    }
}