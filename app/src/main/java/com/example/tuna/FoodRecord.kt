package com.example.tuna

import FoodClass.Foodarr
import MainSystem.*
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_food_record.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class FoodRecord : AppCompatActivity() {
    var e=""
    var A=""
    var B=""
    var C=""
    var D=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_record)
        e=intent.getStringExtra("E")
        A=intent.getStringExtra("A")
        B=intent.getStringExtra("B")
        C=intent.getStringExtra("C")
        D=intent.getStringExtra("D")
        Thread{
            val client= Socket(ip,5010)
            Log.v("e",e)
            val output = client.getOutputStream()
            val writer = PrintWriter(output,true)
            val input = client.getInputStream()
            val reader = BufferedReader(InputStreamReader(input))
            writer.println(e)
            val ItemCount=reader.readLine().toInt()
            Log.v("ee",ItemCount.toString())
            val listData = ArrayList<FoodListItem>()
            for(times in 0..ItemCount)
            {
                var text=reader.readLine()
                Log.v(text,"SS")
                Log.v("??",text.length.toString())
                if(text.length!=0)
                {
                    var textList=text.split(":")
                    Log.v("TEST",textList[0])
                    var name=textList[0]
                    var count=textList[1].toInt()
                    var show=textList[2]
                    var price=0
                    for((key,food) in Foodarr)
                    {
                        if(food.originName==name)
                        {
                            price=food.price*count
                        }
                    }
                    var Price=tran(price)
                    val item=FoodListItem(times+1,name+show,count,Price)
                    listData.add(item)
                }
            }
            runOnUiThread{
                Food_Total.text= tran(reader.readLine())

                val layoutManager = LinearLayoutManager(this)
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                val dataList=test
                dataList.layoutManager = layoutManager
                dataList.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
                var Adapter=DataAdapter(listData)
                dataList.adapter=Adapter
            }


        }.start()
    }

    override fun onBackPressed() {
        val intent = Intent(this@FoodRecord, MainActivity::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)

    }
}