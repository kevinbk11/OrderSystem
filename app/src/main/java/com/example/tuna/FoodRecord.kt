package com.example.tuna

import MainSystem.SendTextToActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_food_record.*
import kotlinx.android.synthetic.main.activity_main.*
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
            val client= Socket("192.168.1.101",5010)
            Log.v("e",e)
            val output = client.getOutputStream()
            val writer = PrintWriter(output,true)
            val input = client.getInputStream()
            val reader = BufferedReader(InputStreamReader(input))
            writer.println(e)
            val ItemCount=reader.readLine().toInt()
            Log.v("ee",ItemCount.toString())
            for(times in 0..ItemCount)
            {
                var text=reader.readLine()
                Log.v("test",text)
            }
            Food_Total.text= reader.readLine()
        }.start()
    }

    override fun onBackPressed() {
        val intent = Intent(this@FoodRecord, MainActivity::class.java)
        SendTextToActivity(A,B,C,D,e,intent)
        startActivity(intent)

    }
}