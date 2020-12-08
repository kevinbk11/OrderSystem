package com.example.tuna

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_end_eat.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class EndEat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_eat)
        Thread{
            var ThisClient= Socket("192.168.43.114",5004)
            val input = ThisClient!!.getInputStream()
            val reader = BufferedReader(InputStreamReader(input))
            val output = ThisClient.getOutputStream()
            var writer = PrintWriter(output, true)
            writer.println(2)
            var tablenumber=reader.readLine()
            Log.v("HI",tablenumber)
            wait.text="感謝您的消費,該次用餐共消費了${reader.readLine()}元"
            Log.v("TEST","HI")
        }.start()
    }

    override fun onBackPressed() {

    }
}