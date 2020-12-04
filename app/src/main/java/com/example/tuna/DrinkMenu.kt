package com.example.tuna

import FoodClass.Foodarr
import MainSystem.SendTextToActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import deleteInterface.deleteListItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_soup_menu.*

class DrinkMenu : AppCompatActivity(),deleteListItem {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_menu)
    }
    override fun onBackPressed() {
        var intent= Intent(this,MainActivity::class.java)
        SendTextToActivity(A2,B2,C2,D2,intent)
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
}