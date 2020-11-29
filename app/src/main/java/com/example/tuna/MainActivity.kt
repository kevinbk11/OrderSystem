package com.example.tuna

import FoodClass.Food1Page.Food1
import FoodClass.Food1Page.Food2
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        A.text="None"
        B.text="None"
        C.text="None"
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
    var foodArr= arrayOf(Food1,Food2)
    fun make1(view: View)
    {
        var arr = arrayOf(A,B,C)
        if(!foodArr[0].append(arr))
        {
            Toast.makeText(applicationContext,"購物車已滿!請刪除其他食物",Toast.LENGTH_LONG)
        }

    }
    fun make2(view:View)
    {
        var arr = arrayOf(A,B,C)
        if(!foodArr[1].append(arr))
        {
            Toast.makeText(applicationContext,"購物車已滿!請刪除其他食物",Toast.LENGTH_LONG)
        }
    }

    fun D1(view:View)
    {
        var arr = arrayOf(A,B,C)
        foodArr[0].del(arr)
    }
    fun D2(view:View)
    {
        var arr = arrayOf(A,B,C)
        foodArr[1].del(arr)
    }
    fun D3()
    {

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
