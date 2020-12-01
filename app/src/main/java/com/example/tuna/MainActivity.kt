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
import kotlinx.android.synthetic.main.activity_noodles_menu.*
import java.io.Serializable

class MainActivity : AppCompatActivity(),deleteListItem{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a=intent.getStringExtra("A")
        var b=intent.getStringExtra("B")
        var c=intent.getStringExtra("C")
        if(a==null)
        {
            A.text="None"
        }
        else
        {
            A.text=a
        }
        if(b==null)
        {
            B.text="None"
        }
        else
        {
            B.text=b
        }

        if(c==null)
        {
            C.text="None"
        }
        else
        {
            C.text=c
        }


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
        val bundle = Bundle()


        bundle.putString("A",A.text.toString())
        bundle.putString("B",B.text.toString())
        bundle.putString("C",C.text.toString())
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
