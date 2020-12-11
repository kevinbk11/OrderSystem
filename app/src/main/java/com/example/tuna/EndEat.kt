package com.example.tuna

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
            val tableNumber=reader.readLine()
            wait.text="感謝您的消費,該次用餐共消費了${reader.readLine()}元"
            var back =Socket("192.168.43.114",5008)
            val i=back.getInputStream()
            val r=BufferedReader(InputStreamReader(i))
            r.readLine()
            var intent= Intent(this,MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("E",(tableNumber.toInt()-1).toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }.start()
    }

    override fun onBackPressed() {
        val t= Toast.makeText(applicationContext,"請至櫃台結帳",Toast.LENGTH_LONG).show()
    }
}