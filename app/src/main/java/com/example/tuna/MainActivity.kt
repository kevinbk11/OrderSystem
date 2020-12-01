package com.example.tuna

import FoodClass.Foodarr
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import deleteInterface.deleteListItem
import kotlinx.android.synthetic.main.activity_noodles.*

class MainActivity : AppCompatActivity(),deleteListItem{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        A.text="None"
        B.text="None"
        C.text="None"
        setContentView(R.layout.activity_noodles)
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

    fun test(View:View)
    {
        Log.v("TEST","test")
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

    /*fun next()
    {
        val intent = Intent(this@MainActivity, Test::class.java)


        val bundle = Bundle()

        bundle.putString("num", 5.toString())
        intent.putExtras(bundle)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
        Toast.makeText(applicationContext, "test", Toast.LENGTH_LONG).show()
    }*/
}
