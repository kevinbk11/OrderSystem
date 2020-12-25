package com.example.tuna

import FoodClass.Foodarr
import MainSystem.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ffd_memu.*

class FfdMemu : AppCompatActivity(), deleteListItem, send, WaitReturn {
    override var app: Context?=null
    var arr:Array<TextView?> = arrayOf()
    override var ThisTableNumber:String?=null
    var e:String?=null
    override var NowList: Array<TextView?> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ffd_memu)
        arr = arrayOf(A6,B6,C6,D6)
        app=applicationContext
        recive(arr,intent)

        e=intent.getStringExtra("E")

        toast = Toast.makeText(applicationContext, full, Toast.LENGTH_LONG)
        updata(arr)
        ThisTableNumber=e
        sendToast = Toast.makeText(app, sended, Toast.LENGTH_SHORT)
        waitReturn(e,app, sendToast)
    }
    override fun onBackPressed() {
        var intent= Intent(this,MainActivity::class.java)
        SendTextToActivity(A6,B6,C6,D6,e,intent)
        startActivity(intent)
    }

    fun D1(view: View)
    {
        delete(A6, Foodarr)
    }
    fun D2(view: View)
    {
        delete(B6, Foodarr)
    }
    fun D3(view: View)
    {
        delete(C6, Foodarr)
    }
    fun D4(view: View)
    {
        delete(D6, Foodarr)
    }

    fun make1(view: View)
    {
        Foodarr["Ffd1"]?.append(arr, toast)
    }
    fun make2(view: View)
    {
        Foodarr["Ffd2"]?.append(arr, toast)
    }

}
